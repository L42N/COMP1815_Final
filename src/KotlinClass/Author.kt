package KotlinClass

class Author {
    private var firstName: String? = null
    private var surname: String? = null


    fun setFirstName(firstName: String?) {
        this.firstName = firstName
    }

    fun setSurname(surname: String?) {
        this.surname = surname
    }

    fun getFirstName(): String? {
        return firstName
    }

    fun getSurname(): String? {
        return surname
    }
}