package KotlinAlgo

import java.util.*

class MergeSort    // Constructor
    (private var authorNames: ArrayList<String>) {
    fun sortAuthors() {
        authorNames = mergeSort(authorNames)
    }

    fun mergeSort(whole: ArrayList<String>): ArrayList<String> {

        // Create two ArrayList object to split the information
        //into left and rights, this is how the merge sort algorithm works,
        // and we need to hold each section in a new object
        var left = ArrayList<String>()
        var right = ArrayList<String>()

        //Variable to hold the middle of the ArrayList
        val middle: Int

        // If the size is == 1 then we don't need to sort
        if (whole.size == 1) {
            return whole
        } else {
            middle = whole.size / 2
            // copy the left half of whole into the left.
            for (i in 0 until middle) {
                left.add(whole[i])
            }

            //copy the right half of whole into the new ArrayList.
            for (i in middle until whole.size) {
                right.add(whole[i])
            }

            // Sort the left and right halves of the ArrayList.
            left = mergeSort(left)
            right = mergeSort(right)

            // Merge the results back together.
            mergeResults(left, right, whole)
        }
        return whole
    }

    private fun mergeResults(left: ArrayList<String>, right: ArrayList<String>, whole: ArrayList<String>) {
        var leftIndex = 0
        var rightIndex = 0
        var wholeIndex = 0

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smallest of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                whole[wholeIndex] = left[leftIndex]
                leftIndex++
            } else {
                whole[wholeIndex] = right[rightIndex]
                rightIndex++
            }
            wholeIndex++
        }
        val rest: ArrayList<String>
        val restIndex: Int
        if (leftIndex >= left.size) {
            // The left ArrayList is finished check the right one
            rest = right
            restIndex = rightIndex
        } else {
            // The right ArrayList has been all checked
            rest = left
            restIndex = leftIndex
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (i in restIndex until rest.size) {
            whole[wholeIndex] = rest[i]
            wholeIndex++
        }
    }

    fun showSortedAuthors() {
        println("Sorted:")
        println(authorNames)
        //        for (int i=0; i< strList.size();i++) {
//            System.out.println(strList.get(i));
//        }
    }
}

/*
var sortedAuthors: java.util.ArrayList<String?>? = java.util.ArrayList()
var sc = Scanner(File("C:\\Users\\hentailover\\Desktop\\AuthorNames.csv"))

while (sc.hasNext()){
    val line = sc.nextLine()
    //setting comma as delimiter pattern
    val authorNames = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    sortedAuthors!!.add(authorNames[0])
}
sc.close()

kotlin.io.println("Before")
kotlin.io.println(sortedAuthors)
var test = MergeSort(sortedAuthors)


test.sortAuthors()
test.showSortedAuthors()
kotlin.io.println("After")*/
