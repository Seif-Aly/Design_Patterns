package Visitor

interface BracketVisitor {
    fun visitRoundBracket(node: RoundBracketNode)
    fun visitSquareBracket(node: SquareBracketNode)
    fun visitCurlyBracket(node: CurlyBracketNode)
}