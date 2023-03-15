package com.example.demo.kotlinpractice.classesexamples

class DemoAbstract(name: String) : AbstractClass(name) {

    override fun displayGen(gender: String) {
        println("Gender is $gender")
    }
}