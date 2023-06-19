package com.example.demo.kotlinpractice.classesexamples

abstract class AbstractClass(name: String) {

    init {
        println("Name is $name")
    }

    fun displayAge(age: Int) {
        println("Age is $age")
    }

    abstract fun displayGen(gender: String)
}