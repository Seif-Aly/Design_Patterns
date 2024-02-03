package Visitor

sealed class BracketNode {
    abstract fun accept(visitor: BracketVisitor)
}