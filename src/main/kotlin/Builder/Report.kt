package Builder

import kotlinx.serialization.Serializable

@Serializable
data class Report(
    val title: String?,
    val task: String?,
    val abstract: String?,
    val tableOfContents: List<String>?,
    val reportContent: List<String>?
)