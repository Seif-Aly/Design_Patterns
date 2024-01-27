package Builder

class ReportDirector(private val reportBuilder: ReportBuilder) {
    fun constructReport(): Report {
        return reportBuilder
            .buildTitle()
            .buildTask()
            .buildAbstract()
            .buildTableOfContents()
            .buildReportContent()
            .build()
    }
}