package Iterator

class CyclicIterator<T>(private val items: List<T>) : Iterator<T> {
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return items.isNotEmpty()
    }

    override fun next(): T {
        if (items.isEmpty()) {
            throw NoSuchElementException("No elements in the iterator.")
        }
        val currentItem = items[currentIndex]
        currentIndex = (currentIndex + 1) % items.size
        return currentItem
    }
}
