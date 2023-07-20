package com.bendingbuddies.core.common.mapper

interface BendingBuddyMapper<Input, Output> {

    fun map(input: Input?): Output

}