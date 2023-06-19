package com.example.demo.kotlinpractice.interfacepractice

class DemoInterface : A, B {

    override fun call() {
        super<A>.call()
        super<B>.call()
    }
}