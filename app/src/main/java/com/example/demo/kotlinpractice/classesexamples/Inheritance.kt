package com.example.demo.kotlinpractice.classesexamples

open class Inheritance(name: String, age: Int) {

    init {
        println("Name: $name, Age: $age")
    }

    open fun display() {
        println("Superclass")
    }
}