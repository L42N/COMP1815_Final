package Scala


import KotlinClass.Book
import KotlinClass.Author

import scala.collection.mutable
import scala.jdk.CollectionConverters._

  class  RadixSort {
    /**
     * A required initialisation class to convert the incoming and outgoing data. (between Java and Scala)
     *
     * @param books - List of books to be organised (Input as Java Lists) - Converted to Scala Lists.
     * @return result - The books list sorted in alphabetical order.
     */
    def initRadixSort(books: java.util.List[Book], sortTitle: Boolean): java.util.List[Book] = {
      val scalaBooks = books.asScala.toArray
      var result = new Array[Book](books.size())
      if (sortTitle) {
        // Sort by authors first then sort again by title.
        val authorSorted = mainRadixSort(scalaBooks, sortAuthor = true)
        result = mainRadixSort(authorSorted, sortAuthor = false)
      } else {
        // Sort by title first then sort again by authors.
        val titleSorted = mainRadixSort(scalaBooks, sortAuthor = false)
        result = mainRadixSort(titleSorted, sortAuthor = true)
      }
      result.toList.asJava
    }

    /**
     * Main radix sort algorithm.
     */
    private def mainRadixSort(books: Array[Book], sortAuthor: Boolean): Array[Book] = {
      // Getting starter data
      val maxDigit = findMaxDigits(books, sortAuthor)

      // Holding data - TreeMap
      var previous = books
      var current = new Array[Book](books.length)

      // Iterate through each digit starting from the right-side of the longest string value.
      for (digit <- maxDigit - 1 to 0 by -1) {
        val treeMap: mutable.TreeMap[Char, Array[Book]] = mutable.TreeMap()
        var currentData = ""
        // Iterate through each book and grab the relevant data.
        previous.foreach(book => {
          if (sortAuthor) {
            currentData = book.getAuthors.toString.stripSuffix("]").stripPrefix("[")
          } else {
            currentData = book.getTitle
          }
          // Check if there's a CHAR at the digit index pointer (if not, assume it's '~' which is the smallest ASCII value)
          if (digit > currentData.length - 1) {
            // See if we already have a bucket for books with no CHAR at the current index position.
            if (treeMap.contains(' ')) {
              // Add them onto the current list of existing books that have no CHAR at the current index position.
              var emptyCharBooks: Array[Book] = treeMap.apply(' ')
              emptyCharBooks = emptyCharBooks :+ book
              treeMap.put(' ', emptyCharBooks)
            } else {
              // Create a new bucket containing books that have no CHAR at the current index position.
              val temp = Array[Book](book)
              treeMap.put(' ', temp)
            }
            // If there's a CHAR at index pointer, see if the bucket already exists.
          } else if (digit <= currentData.length - 1) {
            if (treeMap.contains(currentData(digit))) {
              // Add the current book onto the list that exists with the same key.
              var list: Array[Book] = treeMap.apply(currentData(digit))
              list = list :+ book
              treeMap.put(currentData(digit), list)
            } else {
              // Create a new bucket with that key if it doesn't exist.
              val temp = Array[Book](book)
              treeMap.put(currentData(digit), temp)
            }
          }
        })
        // Clear the data.
        current = Array()
        // Convert TreeMap data into Array (Array[Array[Book]])
        val temp = treeMap.values.toArray
        // Read the temp array and convert it into a normal book array. - Assign it to previous for the next iteration.
        temp.foreach(sub_array => sub_array.foreach(book => current = current :+ book))
        previous = current
      }
      // Return sorted data.
      current
    }

    /**
     * Finds and returns the largest length of digits in a string out of all the authors or titles.
     */
    private def findMaxDigits(books: Array[Book], sortAuthor: Boolean): Int = {
      var maxDigit = 0
      // Get all authors provided by books, compare the string length and find the highest value.
      books.foreach(book => {
        if (sortAuthor) {
          if (book.getAuthors.length > maxDigit) {
            maxDigit = book.getAuthors.length - 2
          }
        } else {
          if (book.getTitle.length > maxDigit) {
            maxDigit = book.getTitle.length
          }
        }
      })
      maxDigit
    }
  }


