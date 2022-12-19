package KotlinClass
import java.io.File

object DataPersistence {

    fun getBooks(path: String): List<Book> {
        val rows = bookToRows(path)
        println(rows)
        return rows
  }
    fun getAuthors(path: String): List<Author> {
        val rows = authToRows(path)
        println(rows)
        return rows
    }

    fun getPublishers(path: String): List<Pub>{
        val rows = pubToRows(path)
        println(rows)
        return rows
    }

    fun bookToRows(path: String): MutableList<Book> {
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

    fun authToRows(path:String): MutableList<Author>{
        val authors:MutableList<Author> = mutableListOf()
        File(path).forEachLine { line ->
            val row = line.split(",")
            val id:String = row[0]
            val firstname:String = row[1]
            val surname:String = row[2]

            authors.add(Author(id, firstname, surname))
        }
        return authors
    }

    fun pubToRows(path: String) : MutableList<Pub>{
        val pubs:MutableList<Pub> = mutableListOf()
        File(path).forEachLine { line ->
            val row = line.split(",")
            val id:String = row[0]
            val publishername:String = row[1]

            pubs.add(Pub(id, publishername))
        }
        return pubs
    }



}