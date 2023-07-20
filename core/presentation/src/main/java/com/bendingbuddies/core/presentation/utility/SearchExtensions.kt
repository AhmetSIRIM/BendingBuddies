package com.bendingbuddies.core.presentation.utility

infix fun String.isLengthGreaterOrEqualTo(bottomBound: Int) = length >= bottomBound

fun String.trimWhitespaceAfterSpace() = takeWhile { it != ' ' }.trim()

