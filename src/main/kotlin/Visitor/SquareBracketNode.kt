package Visitor

class SquareBracketNode : BracketNode() {
    val children: MutableList<BracketNode> = mutableListOf()

    override fun accept(visitor: BracketVisitor) {
        visitor.visitSquareBracket(this)
    }
}