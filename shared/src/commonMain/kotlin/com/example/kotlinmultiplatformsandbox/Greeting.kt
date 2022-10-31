package com.example.kotlinmultiplatformsandbox

class Greeting {
    private val platform: Platform = Platform()

    fun greeting(): String {
        //val year = "\nThere are only ${daysUntilNewYear()} days left until New Year! 🌅"
        return "Guess what it is! > ${platform.platform.reversed()} !"
    }
}