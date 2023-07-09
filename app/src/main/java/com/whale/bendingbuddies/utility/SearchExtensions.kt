package com.whale.bendingbuddies.utility

infix fun String.isLengthGreaterOrEqualTo(bottomBound: Int) = length >= bottomBound

fun String.trimWhitespaceAfterSpace() = takeWhile { it != ' ' }.trim()

