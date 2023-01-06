package KotlinAlgo
import KotlinClass.Book
import kotlin.collections.MutableList
class BubbleSort {

    // Bubble sort by books
    fun bubbleSort(list: MutableList<Book>)  {
        // Iterate through columns until second to last index
        for (j in 0 until list.size - 1) {
            // Iterate through columns
            for (i in 0 until list.size - 1 - j) {
                // If the title from list[i] is alphabetically bigger than list[i+1], swap rows
                if (list[i].title  > (list[i + 1].title) ) {
                    // Swap the mutable list[i] and list[i+1] using a temp value to store list[i]
                    val temp = list[i]
                    list[i]= list[i + 1]
                    list[i + 1]= temp
                }
            }
        }
    }

    // Bubble sort by authors
    fun bubbleSortAuthor(list: MutableList<Book>)  {
        // Iterate through columns until second to last index
        for (j in 0 until list.size - 1) {
            // Iterate through columns
            for (i in 0 until list.size - 1 - j) {
                // If the author from list[i] is alphabetically bigger than list[i+1], swap rows
                if (list[i].authors > (list[i + 1].authors) ) {
                    // Swap the mutable list[i] and list[i+1] using a temp value to store list[i]
                    val temp = list[i]
                    list[i]= list[i + 1]
                    list[i + 1]= temp
                }
            }
        }
    }

}