package KotlinAlgo
import KotlinClass.Book
import KotlinClass.Author
import KotlinClass.Pub

object SearchAlgo {

    fun searchTitle(search: String,books: List<Book>): List<Book>{
        var die = books.filter { book -> book.title.lowercase().contains(search.lowercase()) }
        return die
    }
    fun searchAuthor(search: String,books: List<Book>): List<Book>{
        var die = books.filter { book -> book.authors.lowercase().contains(search.lowercase()) }
        return die
    }
    fun searchAuthorFirst(search: String, authors: List<Author> ): List<Author>{
        var die = authors.filter { author -> author.firstName.lowercase().contains(search.lowercase()) }
        return die
    }
    fun searchAuthorLast(search: String, authors: List<Author> ): List<Author>{
        var die = authors.filter { author -> author.lastName.lowercase().contains(search.lowercase()) }
        return die
    }
    fun searchPubID(search: String,pubs: List<Pub>): List<Pub>{
        var die = pubs.filter { pub -> pub.id.lowercase().contains(search.lowercase()) }
        return die
    }
    fun searchPub(search: String,pubs: List<Pub>): List<Pub>{
        var die = pubs.filter { pub -> pub.pubName.lowercase().contains(search.lowercase()) }
        return die
    }


}