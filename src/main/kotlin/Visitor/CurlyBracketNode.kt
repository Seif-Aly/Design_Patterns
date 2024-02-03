package Visitor

class CurlyBracketNode : BracketNode() {
    val children: MutableList<BracketNode> = mutableListOf()

    override fun accept(visitor: BracketVisitor) {
        visitor.visitCurlyBracket(this)
    }
}