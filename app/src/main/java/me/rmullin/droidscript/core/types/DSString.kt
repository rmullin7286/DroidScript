package me.rmullin.droidscript.core.types

import me.rmullin.droidscript.core.DSFunction
import me.rmullin.droidscript.core.DSParam
import me.rmullin.droidscript.core.DSType

@DSType("string")
data class DSString(val value: String) {
    operator fun plus(other: DSString) = DSString(this.value + other.value)
}

@DSFunction("+")
fun cat(@DSParam("string") x: DSString, @DSParam("string") y: DSString) = x + y

@DSFunction("elem")
fun elem(@DSParam("number") i: DSNumber, @DSParam("string") s: DSString) =
    DSString(s.value.substring(i.toInt(), i.toInt() + 1))

@DSFunction("slice")
fun slice(
    @DSParam("number") start: DSNumber,
    @DSParam("number") end: DSNumber,
    @DSParam("string") s: DSString
): DSString {
    val starti = start.toInt()
    val endi = end.toInt()
    return DSString(s.value.substring(starti, endi))
}

@DSFunction("compare")
fun compareString(@DSParam("string") left: DSString, @DSParam("string") right: DSString) =
    left.value.compareTo(right.value)
