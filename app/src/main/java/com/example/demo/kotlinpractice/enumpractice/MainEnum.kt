package com.example.demo.kotlinpractice.enumpractice

fun main() {

    println(EnumDemo.GOLD.color)
    println(InterfaceEnum.JANUARY.display())

    when (Days.TUESDAY) {
        Days.SUNDAY -> println("Today is Sunday")
        Days.MONDAY -> println("Today is Monday")
        Days.TUESDAY -> println("Today is Tuesday")
        Days.WEDNESDAY -> println("Today is Wednesday")
        Days.THURSDAY -> println("Today is Thursday")
        Days.FRIDAY -> println("Today is Friday")
        Days.SATURDAY -> println("Today is Saturday")
    }
}