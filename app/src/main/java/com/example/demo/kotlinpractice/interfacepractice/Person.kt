package com.example.demo.kotlinpractice.interfacepractice

interface Person {

    val mark: Int
        get() = 20

    fun foo()

    fun display() {
        println("Welcome")
    }
}