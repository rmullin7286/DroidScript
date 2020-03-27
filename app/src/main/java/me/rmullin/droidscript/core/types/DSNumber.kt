package me.rmullin.droidscript.core.types

import me.rmullin.droidscript.core.DSFunction
import me.rmullin.droidscript.core.DSParam
import me.rmullin.droidscript.core.DSType
import me.rmullin.droidscript.util.Either

/**
 * The number primitive type encapsulates both integers and floats.
 * If an operation result can be expressed as an integer, it will be, otherwise it will be expressed as a float
 */
@DSType("number")
data class DSNumber(val value: Either<Int, Double>) {
    constructor(value: Int) : this(Either.Left(value))
    constructor(value: Double) : this(Either.Right(value))
}

fun DSNumber.toInt() = when(this.value) {
    is Either.Left -> this.value.value
    is Either.Right -> Math.floor(this.value.value).toInt()
}

fun DSNumber.toDouble() = when(this.value) {
    is Either.Left -> this.value.value.toDouble()
    is Either.Right -> this.value.value
}

@DSFunction("+")
fun plus(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber): DSNumber = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value + y.value.value)
        is Either.Right -> DSNumber(x.value.value + y.value.value)
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value + y.value.value)
        is Either.Right -> DSNumber(x.value.value + y.value.value)
    }
}

@DSFunction("-")
fun minus(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber): DSNumber = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value - y.value.value)
        is Either.Right -> DSNumber(x.value.value - y.value.value)
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value - y.value.value)
        is Either.Right -> DSNumber(x.value.value - y.value.value)
    }
}

@DSFunction("*")
fun times(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber): DSNumber = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value * y.value.value)
        is Either.Right -> DSNumber(x.value.value * y.value.value)
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value * y.value.value)
        is Either.Right -> DSNumber(x.value.value * y.value.value)
    }
}

@DSFunction("/")
fun div(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber): DSNumber = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value / y.value.value)
        is Either.Right -> DSNumber(x.value.value / y.value.value)
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value / y.value.value)
        is Either.Right -> DSNumber(x.value.value / y.value.value)
    }
}

@DSFunction("rem")
fun rem(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber): DSNumber = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value % y.value.value)
        is Either.Right -> DSNumber(x.value.value % y.value.value)
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value % y.value.value)
        is Either.Right -> DSNumber(x.value.value % y.value.value)
    }
}

@DSFunction("floor")
fun floor(@DSParam("number") x: DSNumber) = when (x.value) {
    is Either.Left -> x
    is Either.Right -> DSNumber(Math.floor(x.value.value).toInt())
}

@DSFunction("ceil")
fun ceil(@DSParam("number") x: DSNumber) = when (x.value) {
    is Either.Left -> x
    is Either.Right -> DSNumber(Math.ceil(x.value.value).toInt())
}

@DSFunction("compare")
fun compareNum(@DSParam("number") x: DSNumber, @DSParam("number") y: DSNumber) = when (x.value) {
    is Either.Left -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value.compareTo(y.value.value))
        is Either.Right -> DSNumber(x.value.value.compareTo(y.value.value))
    }
    is Either.Right -> when (y.value) {
        is Either.Left -> DSNumber(x.value.value.compareTo(y.value.value))
        is Either.Right -> DSNumber(x.value.value.compareTo(y.value.value))
    }
}


