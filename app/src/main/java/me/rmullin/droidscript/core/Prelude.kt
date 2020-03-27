package me.rmullin.droidscript.core

import me.rmullin.droidscript.core.interpreter.ForeignModule
import me.rmullin.droidscript.core.types.*

val prelude = ForeignModule(
    namespace = "prelude",
    functions = setOf(
        // boolean operations
        ::not,
        ::and,
        ::or,
        ::xor,
        //numeric operations
        ::plus,
        ::minus,
        ::times,
        ::div,
        ::rem,
        ::floor,
        ::ceil,
        ::compareNum
        //string operations
    ),
    types = setOf(
        DSNumber::class,
        DSList::class,
        DSString::class,
        DSSymbol::class,
        Nil::class,
        DSBool::class,
        Function::class,
        Macro::class,
        TypecheckFunction::class,
        ForeignFunction::class,
        TypeConstructor::class,
        MultiFunction::class
    )

)