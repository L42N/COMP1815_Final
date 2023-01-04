package KotlinClass
import java.io.File


// Create mutable lists from CSVs with data persistence
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
        val books:MutableList<Book> = mutableListOf()  // Creates read-only mutable list variable
        File(path).forEachLine { line ->  // For loop that iterates through each line, assigned to the parameter 'line'
            val row = line.split(",")  // Splits each line in the CSV by the comma to obtain column values
            val id:String = row[0]
            var title:String = row[1]
            var author:String = row[2]
            val year:String = row[3]
            val publish:String = row[4]
            val subject:String = row[5]

            // Replace vertical bar with correct character (correct character interferes with line.split function above)
            title = title.replace("|", """""")
            author = author.replace("|", ",")

            // Add row to books list
            books.add(Book(id, title, author, year, publish, subject))
        }
        return books
    }

    // Create a mutable list of authors by reading the CSV of authors and adding each row
    fun authToRows(path:String): MutableList<Author>{
        val authors:MutableList<Author> = mutableListOf()  // Creates read-only mutable list variable
        File(path).forEachLine { line ->  // For loop that iterates through each line, assigned to the parameter 'line'
            val row = line.split(",")  // Splits each line in the CSV by the comma to obtain column values
            val id:String = row[0]
            val firstname:String = row[1]
            val surname:String = row[2]

            // Add row to authors list
            authors.add(Author(id, firstname, surname))
        }
        return authors
    }

    // Create a mutable list of publishers by reading the CSV of publishers and adding each row
    fun pubToRows(path:String): MutableList<Pub>{
        val pubs:MutableList<Pub> = mutableListOf()  // Creates read-only mutable list variable
        File(path).forEachLine { line ->  // For loop that iterates through each line, assigned to the parameter 'line'
            val row = line.split(",")  // Splits each line in the CSV by the comma to obtain column values
            val id:String = row[0]
            val pubname:String = row[1]

            // Add row to publisher list
            pubs.add(Pub(id, pubname))
        }
        return pubs
    }
}
