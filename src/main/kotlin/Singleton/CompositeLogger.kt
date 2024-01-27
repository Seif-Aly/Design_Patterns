package Singleton

class CompositeLogger(private val loggers: List<Logger>) : Logger {
    override fun log(type: String, content: String) {
        loggers.forEach { it.log(type, content) }
    }

    override fun logProgramFinish() {
        loggers.forEach { it.logProgramFinish() }
    }
}