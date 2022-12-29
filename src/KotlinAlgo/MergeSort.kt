package KotlinAlgo

import KotlinClass.Book
import java.util.*
import kotlin.collections.MutableList

class MergeSort    // Constructor
{

//fun initMergeSort(){
//
//}

    fun mergeSort(whole: MutableList<Book>): MutableList<Book> {

        // Create two MutableList object to split the information
        //into left and rights, this is how the merge sort algorithm works,
        // and we need to hold each section in a new object
        var left = mutableListOf<Book>()
        var right = mutableListOf<Book>()

        //Variable to hold the middle of the MutableList
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

            //copy the right half of whole into the new MutableList.
            for (i in middle until whole.size) {
                right.add(whole[i])
            }

            // Sort the left and right halves of the MutableList.
            left = mergeSort(left)
            right = mergeSort(right)

            // Merge the results back together.
            mergeResults(left, right, whole)
        }
        return whole
    }


    private fun mergeResults(left: MutableList<Book>, right: MutableList<Book>, whole: MutableList<Book>) {
        var leftIndex = 0
        var rightIndex = 0
        var wholeIndex = 0

        // As long as neither the left nor the right MutableList has
        // been used up, keep taking the smallest of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex].title < right[rightIndex].title) {
                whole[wholeIndex] = left[leftIndex]
                leftIndex++
            } else {
                whole[wholeIndex] = right[rightIndex]
                rightIndex++
            }
            wholeIndex++
        }
        val rest: MutableList<Book>
        val restIndex: Int
        if (leftIndex >= left.size) {
            // The left MutableList is finished check the right one
            rest = right
            restIndex = rightIndex
        } else {
            // The right MutableList has been all checked
            rest = left
            restIndex = leftIndex
        }

        // Copy the rest of whichever MutableList (left or right) was not used up.
        for (i in restIndex until rest.size) {
            whole[wholeIndex] = rest[i]
            wholeIndex++
        }
    }

    fun authMergeSort(whole: MutableList<Book>): MutableList<Book> {

        // Create two MutableList object to split the information
        //into left and rights, this is how the merge sort algorithm works,
        // and we need to hold each section in a new object
        var left = mutableListOf<Book>()
        var right = mutableListOf<Book>()

        //Variable to hold the middle of the MutableList
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

            //copy the right half of whole into the new MutableList.
            for (i in middle until whole.size) {
                right.add(whole[i])
            }

            // Sort the left and right halves of the MutableList.
            left = authMergeSort(left)
            right = authMergeSort(right)

            // Merge the results back together.
            authMergeResults(left, right, whole)
        }
        return whole
    }


    private fun authMergeResults(left: MutableList<Book>, right: MutableList<Book>, whole: MutableList<Book>) {
        var leftIndex = 0
        var rightIndex = 0
        var wholeIndex = 0

        // As long as neither the left nor the right MutableList has
        // been used up, keep taking the smallest of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex].authors < right[rightIndex].authors) {
                whole[wholeIndex] = left[leftIndex]
                leftIndex++
            } else {
                whole[wholeIndex] = right[rightIndex]
                rightIndex++
            }
            wholeIndex++
        }
        val rest: MutableList<Book>
        val restIndex: Int
        if (leftIndex >= left.size) {
            // The left MutableList is finished check the right one
            rest = right
            restIndex = rightIndex
        } else {
            // The right MutableList has been all checked
            rest = left
            restIndex = leftIndex
        }

        // Copy the rest of whichever MutableList (left or right) was not used up.
        for (i in restIndex until rest.size) {
            whole[wholeIndex] = rest[i]
            wholeIndex++
        }
    }





}
