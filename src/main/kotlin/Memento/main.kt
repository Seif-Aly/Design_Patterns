package Memento

import java.util.*

fun main() {
    val editor = TextEditor()
    var input: String?

    while (true) {
        print("Enter a command (add/edit/watch/cancel/exit):")
        input = readLine()

        when (input?.lowercase(Locale.getDefault())) {
            "add" -> {
                println("Enter text to add:")
                val newText = readLine() ?: ""
                editor.add(newText)
            }
            "edit" -> {
                println("Enter text to replace:")
                val newText = readLine() ?: ""
                editor.edit(newText)
            }
            "watch" -> editor.watch()
            "cancel" -> editor.cancel()
            "exit" -> break
            else -> println("Invalid command.")
        }
    }
}