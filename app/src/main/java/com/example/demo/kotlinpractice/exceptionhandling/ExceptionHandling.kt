package com.example.demo.kotlinpractice.exceptionhandling

class ExceptionHandling(message: String) : Exception(message)

fun find(message: String) {
    if (message.length > 10) {
        throw ExceptionHandling("Message is not valid.")
    } else {
        println(message)
    }
}