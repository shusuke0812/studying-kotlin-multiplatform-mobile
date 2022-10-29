package com.example.kotlinmultiplatformsandbox

class Greeting {
    private val platform: Platform = Platform()

    fun greeting(): String {
        //return "Hello, ${Platform().platform}!"
        return "Guess what it is! > ${platform.platform.reversed()}"
    }
}