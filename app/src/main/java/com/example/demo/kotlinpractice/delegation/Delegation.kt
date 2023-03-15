package com.example.demo.kotlinpractice.delegation

class Delegation(val name: String) : DelegateInterface {

    override fun display() {
        println(name)
    }
}

//lazy delegation
val str: String by lazy {
    "Delegation"
}