package KotlinClass

class Book {
    private var title: String? = null
    private lateinit var authors: Array<Author>
    private var yearOfPublication = 0
    private var publisher: String? = null
    private var subject: String? = null


    fun setTitle(title: String?) {
        this.title = title
    }

    fun setAuthors(authors: Array<Author>) {
        this.authors = authors
    }

    fun setYearOfPublication(yearOfPublication: Int) {
        this.yearOfPublication = yearOfPublication
    }

    fun setPublisher(publisher: String?) {
        this.publisher = publisher
    }

    fun setSubject(subject: String?) {
        this.subject = subject
    }

    fun getTitle(): String? {
        return title
    }

    fun getAuthors(): Array<Author>? {
        return authors
    }

    fun getYearOfPublication(): Int {
        return yearOfPublication
    }

    fun getPublisher(): String? {
        return publisher
    }

    fun getSubject(): String? {
        return subject
    }
}