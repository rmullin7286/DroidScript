package me.rmullin.droidscript.core.types

import me.rmullin.droidscript.BadAnnotationError
import me.rmullin.droidscript.core.DSConstructor
import me.rmullin.droidscript.core.DSParam
import me.rmullin.droidscript.core.DSType
import me.rmullin.droidscript.core.interpreter.Environment
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.isSuperclassOf

data class Parameter(val name: DSSymbol, val type: String? = null)

sealed class DSCallable

@DSType("foreign-function")
class ForeignFunction(private val callable: KCallable<*>) : DSCallable() {
    fun call(vararg args: Any?) =
        args.map { it ?: Nil }.toTypedArray().let { callable.call(*it) } ?: Nil

    val params = callable.parameters
        .map { param ->
            val type = param.findAnnotation<DSParam>()?.type
            Parameter(DSSymbol(param.name ?: "unknown"), type)
        }
}

@DSType("typecheck-function")
class TypecheckFunction(private val type: KClass<*>) : DSCallable() {
    fun call(value: Any) = type.isSuperclassOf(value::class)

    val typename = type.findAnnotation<DSType>()?.name
        ?: BadAnnotationError("A type registered in DroidScript should be annotated with @DSType. Found none on ${type.simpleName}")

    val name = "$typename?"
}

@DSType("type-constructor")
class TypeConstructor(type: KClass<*>) : DSCallable() {
    private val constructor = type.constructors.find { it.findAnnotation<DSConstructor>() != null }
        ?: throw BadAnnotationError("Type ${type.simpleName} should have a @DSConstructor annotation")

    fun call(vararg args: Any) = args.map { it ?: Nil }.toTypedArray().let { constructor.call(*it) }
}

@DSType("function")
data class Function(
    val closure: Environment,
    val parameters: List<Parameter>,
    val body: List<Any>,
    val tailCall: Any,
    val name: String? = null
) : DSCallable()

data class MacroReturn(val body: List<Any>, val tailCall: Any)

@DSType("macro")
data class Macro(val parameters: List<Parameter>, val body: List<Any>, val name: String? = null) :
    DSCallable()

@DSType("multi-function")
class MultiFunction : DSCallable() {
    fun register(callable: DSCallable) {
        TODO("finish this function")
    }

    fun findOverload(args: List<Any>): DSCallable {
        TODO("finish this function")
    }
}