package Singleton;
fun main() {
    val logger = LogManager.getLogger()

    do {
        println("Enter log type (inf, wrn, err):")
        val type = readLine()?.toUpperCase() ?: ""
        println("Enter log content:")
        val content = readLine() ?: ""

        logger.log(type, content)

        println("Press 1 to continue OR 0 to exit")
    } while (readLine()?.toIntOrNull() == 1)

    logger.logProgramFinish()
}
