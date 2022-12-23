package KotlinClass
import java.io.File


object DataPersistence {

    //Return mutable list of books by calling bookToRows function
    fun getBooks(path: String): List<Book> {
        return bookToRows(path)
  }

    //Return mutable list of authors by calling authToRows function
    fun getAuthors(path: String): List<Author> {

        return authToRows(path) 
    }

    //Return mutable list of publishers by calling pubToRows function
    fun getPublishers(path: String): List<Pub>{
        return pubToRows(path)
    }

    // Create a mutable list of books by reading the CSV of books and adding each row
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

    // Create a mutable list of authors by reading the CSV of authors and adding each row
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

    // Create a mutable list of publishers by reading the CSV of publishers and adding each row
    fun pubToRows(path:String): MutableList<Pub>{
        val pubs:MutableList<Pub> = mutableListOf()
        File(path).forEachLine { line ->
            val row = line.split(",")
            val id:String = row[0]
            val pubname:String = row[1]

            pubs.add(Pub(id, pubname))
        }
        return pubs
    }
}
