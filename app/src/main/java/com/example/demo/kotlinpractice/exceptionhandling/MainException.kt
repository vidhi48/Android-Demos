package com.example.demo.kotlinpractice.exceptionhandling

fun main() {

    var arr = arrayOf(1, 5, 7)
    try {
        var acc = arr[6]
        println(acc)
    } catch (e: ArrayIndexOutOfBoundsException) {
        println(e)
    } finally {
        println("This block always executes")
    }

    //custom
    try {
        find("abc")
    } catch (e: ExceptionHandling) {
        println(e)
    }
}