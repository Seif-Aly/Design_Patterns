package Visitor

class RoundBracketNode : BracketNode() {
    override fun accept(visitor: BracketVisitor) {
        visitor.visitRoundBracket(this)
    }
}