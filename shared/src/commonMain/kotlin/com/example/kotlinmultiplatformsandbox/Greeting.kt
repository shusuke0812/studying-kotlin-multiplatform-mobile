package com.example.kotlinmultiplatformsandbox

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}