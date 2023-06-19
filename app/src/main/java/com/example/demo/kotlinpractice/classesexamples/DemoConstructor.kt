package com.example.demo.kotlinpractice.classesexamples

//Primary Constructor
class DemoConstructor public constructor(var name: String = "Patel", var age: Int) {

    init {
        println("Name: $name, Age: $age")
    }
}