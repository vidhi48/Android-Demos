package com.example.demo.kotlinpractice

fun main() {

    //if-else
    val a = 5
    val b = 20
    if (a > b) {
        print("a is larger")
    } else {
        println("b is larger")
    }

    //instead of ternary
    val max = if (a > b) a else b
    println(max)

    //if expression
    val max2 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    //when as an expression
    val num1 = 10
    val num2 = 5
    val find = when (val str = "+") {
        "-" -> num1 - num2
        "+" -> num1 + num2
        "*" -> num1 * num2
        else -> "$str is wrong operator"
    }
    println("Ans: $find")

    //When as a statement
    when (-1) {
        1, 2, 3 -> println("n is a positive integer less than 4.")
        0 -> println("n is zero")
        -1, -2 -> println("n is a negative integer greater than 3.")
    }

    //while
    println("While Loop:")
    var c = 1
    while (c <= 5) {
        println(c)
        c++
    }

    //do-while
    println("Do-while Loop: ")
    val arr = arrayOf("one", "two", "three")
    var s = 0
    do {
        println(arr[s])
        s++
    } while (s < arr.size)

    //for with range
    for (i in 1..5) {
        print(" $i")
    }

    //for down
    println()
    for (i in 5 downTo 1 step 2) {
        print(" $i")
    }
    println()

    //label break
    println("break statement: ")
    for (i in 1..3) {
        ne@ for (j in 1..5) {
            if (j == 2) {
                break@ne
            }
            println("i= $i j= $j")
        }
    }
    println()

    println("Continue statement: ")
    //label continue
    ne@ for (i in 1..3) {
        for (j in 1..5) {
            if (j == 2) {
                continue@ne
            }
            println("i= $i j= $j")
        }
    }
}