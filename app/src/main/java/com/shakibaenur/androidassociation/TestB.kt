package com.shakibaenur.androidassociation

/**
 * Created by Shakiba E Nur on 01,July,2024
 */
class TestB(name: String, cat: String, val age: Int) : TestA(name, cat) {

    var value=2
        set(value) {
            if(value in 0..100){
                field=value
            }else{
                field=0
            }
        }

    fun increaseValue(){
        value++
        println("Value increased to $value")
    }
}