/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

@file:JvmName("Package")

package org.gjt.jclasslib.structures

import kotlin.reflect.KClass

/**
 * Set this JVM System property to true to switch on debugging for
 * reading and writing class files.
 */
const val SYSTEM_PROPERTY_DEBUG = "jclasslib.io.debug"

/**
 * Set this system property to skip reading all attributes
 */
const val SYSTEM_PROPERTY_SKIP_ATTRIBUTES = "jclasslib.io.skipAttributes"

internal var isDebug: Boolean = java.lang.Boolean.getBoolean(SYSTEM_PROPERTY_DEBUG)

internal fun warning(message: String) {
    print("[warning] ")
    println(message)
}

internal fun debug(message: String) {
    print("[debug] ")
    println(message)
}

internal val Int.hex: String
    get() = "0x${Integer.toHexString(this)}"

internal fun Int.paddedHex(length: Int): String {
    return "0x" + this.hex.padStart(length, '0')
}

private val arraySingletons = hashMapOf<KClass<*>, Array<*>>()

@Suppress("UNCHECKED_CAST")
internal inline fun <reified T> emptyArraySingleton(): Array<T> = arraySingletons.getOrPut(T::class) {
    arrayOfNulls<T>(0)
} as Array<T>

