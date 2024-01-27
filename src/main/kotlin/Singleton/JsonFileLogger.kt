package Singleton

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class JsonFileLogger : Logger {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    private val file = File("log.json")

    init {
        log("inf", "Program started")
    }

    @Synchronized
    override fun log(type: String, content: String) {
        val messageType = MessageType.values().find { it.name == type.toUpperCase() }
        if (messageType != null) {
            val timestamp = dateFormat.format(Date())
            val logMessage = LogMessage(type, timestamp, content)
            val jsonMessage = Json.encodeToString(logMessage) + "\n"
            val existingData = if (file.exists()) {
                file.readText()
            } else {
                ""
            }

            val updatedData = if (existingData.isNotEmpty()) {
                existingData.dropLast(1) + ",\n" + jsonMessage + "\n]"
            } else {
                "[$jsonMessage\n]"
            }

            file.writeText(updatedData)
        } else {
            println("Error: Invalid log type '$type'")
        }
    }

    override fun logProgramFinish() {
        log("inf", "Program finished")
    }
}