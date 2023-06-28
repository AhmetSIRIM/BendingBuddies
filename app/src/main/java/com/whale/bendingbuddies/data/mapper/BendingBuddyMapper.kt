package com.whale.bendingbuddies.data.mapper

interface BendingBuddyMapper<Input, Output> {

    fun map(input: Input?): Output

}