package com.whale.bendingbuddies.utility

infix fun String.okWith(bottomBound: Int) = length >= bottomBound

fun String.trimWhitespaceAfterSpace(): String = takeWhile { it != ' ' }.trim()

