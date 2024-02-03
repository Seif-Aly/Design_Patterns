package Iterator
import java.util.*

fun main() {
    val photos = listOf("photo1", "photo2", "photo3", "photo4")
    val iterator = CyclicIterator(photos)

    val delay = 1000
    val timer = Timer()

    val task = object : TimerTask() {
        override fun run() {
            println(iterator.next())
        }
    }

    timer.scheduleAtFixedRate(task, 0, delay.toLong())
}