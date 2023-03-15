package com.example.demo.kotlinpractice.enumpractice

enum class InterfaceEnum : ProdLimit {

    JANUARY {
        override fun display() = 31
    },
    FEBRUARY {
        override fun display() = 28
    }
}