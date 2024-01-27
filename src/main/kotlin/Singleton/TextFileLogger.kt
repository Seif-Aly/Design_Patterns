package Singleton

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class TextFileLogger : Logger {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    private val file = File("log.txt")

    init {
        log("inf", "Program started")
    }

    @Synchronized
    override fun log(type: String, content: String) {
        val messageType = MessageType.values().find { it.name == type.toUpperCase() }
        if (messageType != null) {
            val timestamp = dateFormat.format(Date())
            val message = "[$timestamp] [$type] - $content\n"
            file.appendText(message)
        } else {
            println("Error: Invalid log type '$type'")
        }
    }

    override fun logProgramFinish() {
        log("inf", "Program finished")
    }
}