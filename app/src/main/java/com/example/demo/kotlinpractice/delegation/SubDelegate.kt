package com.example.demo.kotlinpractice.delegation

class SubDelegate(delegate: DelegateInterface) : DelegateInterface by delegate {

    override fun display() {
        println("Delegation")
    }
}