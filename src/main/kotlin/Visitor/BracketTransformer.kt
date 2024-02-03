package Visitor

class BracketTransformer : BracketVisitor {
    private val transformedTree: MutableList<BracketNode> = mutableListOf()

    override fun visitRoundBracket(node: RoundBracketNode) {
        transformedTree.add(RoundBracketNode())
    }

    override fun visitSquareBracket(node: SquareBracketNode) {
        transformedTree.add(SquareBracketNode())
    }

    override fun visitCurlyBracket(node: CurlyBracketNode) {
        val squareBracketNode = SquareBracketNode()
        node.children.forEach { it.accept(this) }
        squareBracketNode.children.addAll(transformedTree)
        transformedTree.clear()
        transformedTree.add(squareBracketNode)
    }

    fun getTransformedTree(): List<BracketNode> {
        return transformedTree
    }
}