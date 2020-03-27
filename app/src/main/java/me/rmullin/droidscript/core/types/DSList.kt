package me.rmullin.droidscript.core.types

import me.rmullin.droidscript.core.DSMember
import me.rmullin.droidscript.core.DSType

@DSType("list")
data class DSList(@DSMember("head") val head: Any, @DSMember("tail") val tail: DSList?) : Iterable<Any> {
    override fun iterator(): Iterator<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private class DSListIterator(parent: DSList) : Iterator<Any> {
        private var current : DSList? = parent;

        override fun hasNext(): Boolean = current != null

        override fun next(): Any {
            val (head, tail) = current!!
            current = tail
            return head
        }

    }

}

fun List<Any>.toDSList() = this.foldRight(null){it: Any, acc: DSList? -> DSList(it, acc)}

fun Array<Any>.toDSList() = this.foldRight(null){it: Any, acc: DSList? -> DSList(it, acc)}