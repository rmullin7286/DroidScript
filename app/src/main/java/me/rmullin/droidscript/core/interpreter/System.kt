package me.rmullin.droidscript.core.interpreter

/**
 * The system context for an interpreter
 */
class System {
    private val moduleCache: MutableMap<String, Module> = mutableMapOf()
}