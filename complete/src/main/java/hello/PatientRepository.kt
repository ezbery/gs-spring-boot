package hello

import org.springframework.data.repository.CrudRepository

interface PatientRepository : CrudRepository<Patient, Long> {

    fun findByFirstName(firstName: String): List<Patient>

    fun findByLastName(lastName: String): List<Patient>

    fun findByPesel(pesel: String): List<Patient>

    fun findById(id: Long): List<Patient>
}