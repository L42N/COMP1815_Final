package KotlinClass
import java.io.File

object DataPersistence {

    fun getBooks(path: String): List<Book> {
        val rows = fileToRows(path)
        println(rows)
        return rows
  }
    fun getAuthors(){

    }

    fun getPublishers(){

    }

    fun fileToRows(path: String): MutableList<Book> {
        val books:MutableList<Book> = mutableListOf()
        File(path).forEachLine { line ->
            val row = line.split(",")
            val id:String = row[0]
            val title:String = row[1]
            val author:String = row[2]
            val year:String = row[3]
            val publish:String = row[4]
            val subject:String = row[5]

            books.add(Book(id, title, author, year, publish, subject))
        }
        return books
    }


}