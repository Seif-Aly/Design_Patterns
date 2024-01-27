package Singleton

import kotlinx.serialization.Serializable

@Serializable
data class LogMessage(
    val type: String,
    val timestamp: String,
    val content: String
)