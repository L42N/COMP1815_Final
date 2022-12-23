package KotlinAlgo
import KotlinClass.Book
import kotlin.collections.MutableList
class BubbleSort {

    fun bubbleSort(list: MutableList<Book>)  {
        for (j in 0 until list.size - 1) {
            for (i in 0 until list.size - 1 - j) {
                if (list[i].title  > (list[i + 1].title) ) {
                    val temp = list[i]
                    list[i]= list[i + 1]
                    list[i + 1]= temp
                }
            }
        }

    }


}