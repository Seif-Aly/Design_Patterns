package Memento
import java.util.Stack

class TextEditor {
    private var text: String = ""
    private val history: Stack<TextMemento> = Stack()

    fun add(newText: String) {
        history.push(TextMemento(text))
        text = newText
    }

    fun edit(newText: String) {
        if (history.isNotEmpty()) {
            history.push(TextMemento(text))
            text = newText
        } else {
            println("No text to edit.")
        }
    }

    fun watch() {
        println("Current Text: $text")
    }

    fun cancel() {
        if (history.isNotEmpty()) {
            text = history.pop().text
            println("Undo successful. Current Text: $text")
        } else {
            println("No changes to undo.")
        }
    }
}