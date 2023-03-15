package com.example.demo.kotlinpractice.delegation

import kotlin.properties.Delegates

//Observable Delegation
class New {

    var name: String by Delegates.observable("nothing") { _, oldValue, newValue ->
        println("OldValue: $oldValue, NewValue: $newValue")
    }
}