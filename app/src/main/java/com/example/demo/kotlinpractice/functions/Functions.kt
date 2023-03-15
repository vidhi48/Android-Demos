package com.example.demo.kotlinpractice.functions

//infix function
class Demo {
    infix fun display(num: Int): Int {
        return num
    }
}

//recursion factorial
fun fact(num: Int): Int {
    return if (num == 1)
        num
    else
        num * fact(num - 1)
}

//lambdas
val sum1 = { a: Int, b: Int -> a + b }
val sum2: (Int, Int) -> Int = { a, b -> a + b }

//shorthand lambda
val arrNum = arrayOf(-2, 4, -5)

//anonymous functions
val anonymousExample = fun(x: Int, y: Int): Int = x + y
val mul = fun(a: Int, b: Int): Int {
    return a * b
}

//inline function
inline fun foo(myFoo: () -> Unit) {
    myFoo()
    println("Welcome")
}

//cross-inlined function
inline fun inDemo(crossinline myIn: () -> Unit, newIn: () -> Unit) {
    myIn()
    newIn()
    println("Cross inline")
}

//extension function
fun Student.isMark(mark: Int): Boolean {
    return mark > 90
}

//Extension overload
fun Example.printFunctionType() {
    println("Extension function")
}

fun Example2.printFunctionType(i: Int) {
    println("Extension function $i")
}

//Extension Property
var ExtensionDemo2.sumNu: Int
    get() = a
    set(value) {
        a = value + 20
    }


