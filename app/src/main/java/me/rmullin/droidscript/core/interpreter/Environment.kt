package me.rmullin.droidscript.core.interpreter

import me.rmullin.droidscript.LookupError
import me.rmullin.droidscript.RedefinitionError
import me.rmullin.droidscript.core.types.DSSymbol

/**
 * A class representing the current call stack and scope of execution
 */
data class Environment(val calling: Environment? = null, val parent: Environment? = null) {
    private val current: MutableMap<DSSymbol, Any> = mutableMapOf()

    fun define(name: DSSymbol, value: Any) =
        if(name in current) throw RedefinitionError("value $name already defined in current scope", this)
        else current[name] = value

    fun lookup(name: DSSymbol) : Any = current[name]
        ?: parent?.lookup(name)
        ?: throw LookupError("no value $name in current scope", this)
}