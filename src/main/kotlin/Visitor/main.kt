package Visitor

fun main() {
    println("Enter the input bracket expression:")
    val inputExpression = readLine() ?: ""

    val root = CurlyBracketNode()
    val square1 = SquareBracketNode()
    val round1 = RoundBracketNode()
    val curly1 = CurlyBracketNode()
    val round2 = RoundBracketNode()
    val round3 = RoundBracketNode()

    root.children.add(square1)
    square1.children.add(round1)
    square1.children.add(curly1)
    square1.children.add(round3)
    curly1.children.add(round2)

    val transformer = BracketTransformer()

    root.accept(transformer)

    val transformedNodes = transformer.getTransformedTree()

    val outputExpression = convertToBracketExpression(transformedNodes)
    println("Original Expression: $inputExpression")
    println("Transformed Expression: $outputExpression")
}

fun convertToBracketExpression(nodes: List<BracketNode>): String {
    val expression = StringBuilder()
    nodes.forEach { node ->
        when (node) {
            is RoundBracketNode -> expression.append("()")
            is SquareBracketNode -> expression.append("[]")
            is CurlyBracketNode -> expression.append("{}")
        }
    }
    return expression.toString()
}