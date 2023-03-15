package com.example.demo.kotlinpractice.classesexamples

class SubInherit(name: String, age: Int, gender: String) : Inheritance(name, age) {

    init {
        println("Name: $name, Age: $age, Gender: $gender")
    }

    override fun display() {
        super.display()
        println("subclass")
    }
}