package Builder

interface ReportBuilder {
    fun buildTitle(): ReportBuilder
    fun buildTask(): ReportBuilder
    fun buildAbstract(): ReportBuilder
    fun buildTableOfContents(): ReportBuilder
    fun buildReportContent(): ReportBuilder
    fun build(): Report
}