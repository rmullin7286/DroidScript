package me.rmullin.droidscript.core.types

import me.rmullin.droidscript.core.DSFunction
import me.rmullin.droidscript.core.DSParam
import me.rmullin.droidscript.core.DSType

@DSType("bool")
data class DSBool(val value: Boolean)

@DSFunction("not")
fun not(@DSParam("bool") b: DSBool) = DSBool(!b.value)

@DSFunction("and")
fun and(@DSParam("bool") x: DSBool, @DSParam("bool") y: DSBool) = DSBool(x.value && y.value)

@DSFunction("or")
fun or(@DSParam("bool") x: DSBool, @DSParam("bool") y: DSBool) = DSBool(x.value || y.value)

@DSFunction("xor")
fun xor(@DSParam("bool") x: DSBool, @DSParam("bool") y: DSBool) = DSBool(x.value xor y.value)