package me.rmullin.droidscript.core

/**
 * This is used to annotate types that will be registered with droidscript
 */
annotation class DSType(val name: String)

/**
 * This is used to annotate members of types that should be registered with droidscript.
 * Members are left unregistered by default
 */
annotation class DSMember(val name: String)

/**
 * This annotation is used to annotate constructors that should be used from droidscript.
 * Only one constructor is allowed per class, and the constructor will be called using the class name
 */
annotation class DSConstructor

/**
 * This annotation is used to annotate parameters to functions that will be overloaded using different types.
 * Droidscript supports function overloading depending on the input type given
 */
annotation class DSParam(val type: String)

/**
 * This annotation is used to mark a function that will be used in DroidScript
 */
annotation class DSFunction(val name: String)