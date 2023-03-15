package com.example.demo.kotlinpractice

class OperatorOverloading(val x: Int, val y: Int) {
    operator fun plus(p: OperatorOverloading): OperatorOverloading {
        return OperatorOverloading(x + p.x, y + p.y)
    }
}

fun main() {
    val p1 = OperatorOverloading(3, -8)
    val p2 = OperatorOverloading(2, 9)
    val sum = p1 + p2
    println("Sum = ${sum.x}, ${sum.y}")
}