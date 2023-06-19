package com.example.demo.kotlinpractice.genericpractice

//Out- Covariance
class CovarianceDemo<T>(age: Int) {

    var ageOf = age

    init {
        println(ageOf)
    }
}