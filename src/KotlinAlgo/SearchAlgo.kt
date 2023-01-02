package KotlinAlgo
import KotlinClass.Book
import KotlinClass.Author
import KotlinClass.Pub

object SearchAlgo {
    //this lambda function filters and returns the list of book titles from the List of Book class stored as books from the search String input converted to lowercase
    fun searchTitle(search: String,books: List<Book>): List<Book>{
        var title = books.filter { book -> book.title.lowercase().contains(search.lowercase()) }
        return title
    }
    //this lambda function filters and returns the list of book authors from the List of Book class stored as books from the search String input converted to lowercase
    fun searchAuthor(search: String,books: List<Book>): List<Book>{
        var author = books.filter { book -> book.authors.lowercase().contains(search.lowercase()) }
        return author
    }
    //this lambda function filters and returns the list of authors first name from the List of Author class stored as authors from the search String input converted to lowercase
    fun searchAuthorFirst(search: String, authors: List<Author> ): List<Author>{
        var firstAuthor = authors.filter { author -> author.firstName.lowercase().contains(search.lowercase()) }
        return firstAuthor
    }
    //this lambda function filters and returns the list of author's last name from the List of Author class stored as authors from the search String input converted to lowercase
    fun searchAuthorLast(search: String, authors: List<Author> ): List<Author>{
        var lastAuthor = authors.filter { author -> author.lastName.lowercase().contains(search.lowercase()) }
        return lastAuthor
    }

    //this lambda function filters and returns the list of Publisher ID from the List of Pub class stored as pubs from the search String input converted to lowercase
    fun searchPubID(search: String,pubs: List<Pub>): List<Pub>{
        var pubID = pubs.filter { pub -> pub.id.lowercase().contains(search.lowercase()) }
        return pubID
    }

    //this lambda function filters and returns the list of Publisher Name from the List of Pub class stored as pubs from the search String input converted to lowercase
    fun searchPub(search: String,pubs: List<Pub>): List<Pub>{
        var publisher = pubs.filter { pub -> pub.pubName.lowercase().contains(search.lowercase()) }
        return publisher
    }


}