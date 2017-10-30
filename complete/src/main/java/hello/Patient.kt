package hello

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val pesel: String = "",
        val firstName: String = "",
        val lastName: String = "") {
    constructor(pesel: String, firstName: String, lastName: String) : this(null, pesel, firstName, lastName)

    override fun toString(): String {
        return String.format(
                "Patient[id=%d, firstName='%s', lastName='%s', pesel='%s']",
                id, firstName, lastName, pesel)
    }
}