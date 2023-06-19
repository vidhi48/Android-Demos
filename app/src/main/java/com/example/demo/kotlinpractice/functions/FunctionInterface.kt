package com.example.demo.kotlinpractice.functions

fun interface DemoInter {

    val name: String
        get() = "vidhi"

    fun find()
}

class FuncInterface : DemoInter {

    override val name: String
        get() = super.name

    override fun find() {
        println("Single Abstract Method")
    }
}