package com.dev.myapplication

import java.util.Observable
import java.util.Observer

class ChristmasTreeState : Observable() {
    var state: String = "Cây thông chưa trang trí"
        set(value) {
            field = value
            setChanged()
            notifyObservers(value)
        }
}

class User(private val name: String) : Observer {
    override fun update(o: Observable?, arg: Any?) {
        println("$name được thông báo: $arg")
    }
}
