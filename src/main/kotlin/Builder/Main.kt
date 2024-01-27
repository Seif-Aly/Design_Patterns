package Builder
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {

    do {
        val reportBuilder = ConcreteReportBuilder()
        val reportDirector = ReportDirector(reportBuilder)
        val report = reportDirector.constructReport()

        val jsonReport = Json.encodeToString(report)

        val filePath = "report.json"
        val existingData = if (File(filePath).exists()) {
            File(filePath).readText()
        } else {
            ""
        }

        val updatedData = if (existingData.isNotEmpty()) {
            existingData.dropLast(1) + ",\n" + jsonReport + "\n]"
        } else {
            "[$jsonReport\n]"
        }

        File(filePath).writeText(updatedData)
        println(updatedData)
        println("The report saved to $filePath")
        println("Press 1 to continue OR 0 to exit")
        val toExit = readLine()?.toIntOrNull()
    } while (toExit == 1)
}
