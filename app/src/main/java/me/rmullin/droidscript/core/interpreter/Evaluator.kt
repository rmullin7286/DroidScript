package me.rmullin.droidscript.core.interpreter

import me.rmullin.droidscript.InvalidArgumentError
import me.rmullin.droidscript.TypeError
import me.rmullin.droidscript.core.types.*
import me.rmullin.droidscript.core.types.Function

/**
 * Evaluates DroidScript AST
 */
class Evaluator {
    fun evalModule(env: Environment, ast: List<Any>) = ast.forEach { evalExpression(env, it) }

    fun evalExpression(env: Environment, ast: Any) = when (ast) {
        is DSList -> evalList(env, ast)
        else -> ast
    }

    tailrec fun evalList(env: Environment, ast: DSList): Any {
        var newEnv = env
        val rest = ast.tail?.toList()?.toTypedArray() ?: emptyArray()
        val first = evalExpression(env, ast.head) as? DSCallable
            ?: throw TypeError("The first value of an expression should be callable", env)

        return when (first) {
            is ForeignFunction -> first.call(*rest)
            is TypecheckFunction ->
                if (rest.size != 1)
                    throw InvalidArgumentError("invalid arguments supplied to typecheck function ${first.name}. Expecting 1 argument. Got ${rest.size}")
                else
                    first.call(rest[0])
            is TypeConstructor -> first.call(*rest)
            is Function -> {
                newEnv = Environment(env, first.closure)
                first.parameters.map(Parameter::name).zip(rest).forEach { (name, value) ->
                    newEnv.define(name, evalExpression(env, value))
                }
                first.body.forEach { evalExpression(newEnv, it) }
                val tailCall = first.tailCall
                if(tailCall is DSList) {
                    if(tailCall.head is Macro)
                        evalList(newEnv, tailCall)
                    else {
                        val tailEvaluated = DSList(tailCall.head, tailCall.tail?.map{evalExpression(newEnv, it)}?.toDSList())
                        evalList(env, tailEvaluated)
                    }
                }
                else evalExpression(newEnv, tailCall)
            }
            is Macro -> {
                val expanded = macroExpand(env, first, rest)
                expanded.body.forEach { evalExpression(env, it) }
                if(expanded.tailCall is DSList)
                    evalList(env, expanded.tailCall)
                else
                    evalExpression(env, expanded.tailCall)
            }
            is MultiFunction -> evalList(env, DSList(first.findOverload(rest.toList()), rest.toDSList()))
        }
    }

    private fun macroExpand(env: Environment, macro: Macro, args: Array<Any>): MacroReturn {
        val newEnv = Environment(parent = env)
        macro.parameters.map(Parameter::name).zip(args).forEach { (name, value) ->
            newEnv.define(name, value)
        }

        val evaluated = macro.body.map{evalExpression(newEnv, it)}
        return MacroReturn(evaluated.dropLast(1), evaluated.last())
    }
}
