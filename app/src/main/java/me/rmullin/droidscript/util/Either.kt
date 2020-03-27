package me.rmullin.droidscript.util

/**
 * A class that can represent either type A or type B
 */
sealed class Either<A, B> {
    class Left<A, B>(val value: A): Either<A, B>()
    class Right<A, B>(val value: B): Either<A, B>()
}