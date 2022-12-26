package KotlinAlgo
import KotlinClass.Book
import KotlinClass.Author
import KotlinClass.Pub
object SearchAlgo {

    fun searchTitle(search: String,books: List<Book>): List<Book>{
        var die = books.filter { book -> book.title.lowercase().contains(search.lowercase()) }
        return die
    }
    
    

}