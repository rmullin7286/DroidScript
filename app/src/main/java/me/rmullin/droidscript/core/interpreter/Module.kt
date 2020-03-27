package me.rmullin.droidscript.core.interpreter

import me.rmullin.droidscript.BadAnnotationError
import me.rmullin.droidscript.core.DSConstructor
import me.rmullin.droidscript.core.DSFunction
import me.rmullin.droidscript.core.DSType
import me.rmullin.droidscript.core.types.*
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

sealed class Module {
    abstract val namespace: String
    abstract val members: Map<DSSymbol, Any>
}

class ForeignModule(
    override val namespace: String,
    functions: Set<KCallable<*>>,
    types: Set<KClass<*>>
) : Module() {
    override val members: Map<DSSymbol, Any>

    init {
        val processedFunctions = functions.map {
            val name = it.findAnnotation<DSFunction>()?.name?.let(::DSSymbol)
                ?: throw BadAnnotationError("function ${it.name} in foreign namespace $namespace should be annotated @DSFunction")
            val callable = ForeignFunction(it)
            name to callable
        }

        val processedTypes = types.flatMap {
            val name = it.findAnnotation<DSType>()?.name
                ?: throw BadAnnotationError("type ${it.simpleName} should have annotation @DSType. None found.")
            val typecheckName = DSSymbol("$name?")
            val typechecks = TypecheckFunction(it)
            val constructor =
                if (it.constructors.find { type -> type.findAnnotation<DSConstructor>() != null } != null) TypeConstructor(
                    it
                )
                else null

            if (constructor == null) listOf(typecheckName to typechecks)
            else listOf(typecheckName to typechecks, DSSymbol(name) to constructor)
        }

        val map = mutableMapOf<DSSymbol, Any>()
        for ((name, func) in (processedFunctions + processedTypes)) {
            if (name in map) {
                val cur = map[name]!!
                if (cur is MultiFunction)
                    cur.register(func)
                else
                    map[name] = MultiFunction().apply {
                        register(cur as DSCallable) // this should be safe at the moment but maybe not in the future
                        register(func)
                    }
            } else {
                map[name] = func
            }
        }

        members = map
    }
}

// this class also acts as a proxy to a foreign module if it exists
data class DSModule(
    override val namespace: String,
    override val members: Map<DSSymbol, Any>,
    private val foreignModule: ForeignModule?
) : Module()