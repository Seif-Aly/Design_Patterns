package Builder

class ConcreteReportBuilder : ReportBuilder {
    private var title: String? = null
    private var task: String? = null
    private var abstract: String? = null
    private var tableOfContents: List<String>? = null
    private var reportContent: List<String>? = null

    override fun buildTitle(): ReportBuilder {
        println("Starting Program")
        print("Enter title:")
        title = readLine()
        return this
    }

    override fun buildTask(): ReportBuilder {
        print("Enter task:")
        task = readLine()
        return this
    }

    override fun buildAbstract(): ReportBuilder {
        print("Enter abstract:")
        abstract = readLine()
        return this
    }

    override fun buildTableOfContents(): ReportBuilder {
        println("Enter table of contents (separate items by comma):")
        tableOfContents = readLine()?.split(",")?.map { it.trim() }
        return this
    }

    override fun buildReportContent(): ReportBuilder {
        println("Enter report content (separate by comma):")
        reportContent = readLine()?.split(",")?.map { it.trim() }
        return this
    }


    override fun build(): Report {
        return Report(title, task, abstract, tableOfContents, reportContent)
    }
}