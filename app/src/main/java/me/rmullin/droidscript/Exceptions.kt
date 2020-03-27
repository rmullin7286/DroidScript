package me.rmullin.droidscript

import me.rmullin.droidscript.core.interpreter.Environment
import java.lang.Exception

abstract class BaseDSException(message: String, val environment: Environment? = null) : Exception(message)

class RedefinitionError(message: String, environment: Environment? = null) : BaseDSException(message, environment)

class LookupError(message: String, environment: Environment? = null) : BaseDSException(message, environment)

class TypeError(message: String, environment: Environment? = null) : BaseDSException(message, environment)

class InvalidArgumentError(message: String, environment: Environment? = null) : BaseDSException(message, environment)

class BadAnnotationError(message: String) : Exception(message)