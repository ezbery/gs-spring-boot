package hello

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PatientRepository : CrudRepository<Patient, Long> {

    fun findByFirstName(firstName: String): List<Patient>

    fun findByLastName(lastName: String): List<Patient>

    fun findByPesel(pesel: String): List<Patient>

    fun findById(id: Long): List<Patient>

    fun findByIdOrFirstNameOrLastNameOrPesel(
            @Param("id") id: Long?,
            @Param("firstName") firstName: String?,
            @Param("lastName") lastName: String?,
            @Param("pesel") pesel: String?
    ): List<Patient>
}