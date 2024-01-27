package Singleton

object LogManager {
    private var logger: Logger? = null

    fun getLogger(): Logger {
        if (logger == null) {
            logger = CompositeLogger(listOf(TextFileLogger(), JsonFileLogger()))
        }
        return logger!!
    }
}