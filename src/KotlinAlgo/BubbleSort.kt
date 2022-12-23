package KotlinAlgo
import KotlinClass.Book
import kotlin.collections.MutableList
class BubbleSort {

    fun bubbleSort(list: MutableList<Book>)  {

        for (j in 0 until list.size - 1) {
            for (i in 0 until list.size - 1 - j) {
                //if the mutable list[i] compares list[i+1] if it is bigger alphabetically based on Book class titles
                if (list[i].title  > (list[i + 1].title) ) {
                    // swap the mutable list[i] and list[i+1]
                    val temp = list[i]
                    list[i]= list[i + 1]
                    list[i + 1]= temp
                }
            }
        }
    }

    fun bubbleSortAuthor(list: MutableList<Book>)  {

        for (j in 0 until list.size - 1) {
            for (i in 0 until list.size - 1 - j) {
                //if the mutable list[i] compares list[i+1] if it is bigger alphabetically based on Book authors
                if (list[i].authors > (list[i + 1].authors) ) {
                    // swap the mutable list[i] and list[i+1]
                    val temp = list[i]
                    list[i]= list[i + 1]
                    list[i + 1]= temp
                }
            }
        }
    }

}