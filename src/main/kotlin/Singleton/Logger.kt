package Singleton

interface Logger {
    fun log(type: String, content: String)
    fun logProgramFinish()
}