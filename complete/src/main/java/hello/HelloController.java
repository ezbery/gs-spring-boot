package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public List<Patient> returnAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    @GetMapping("/")
    public List<Patient> returnPatient(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "pesel", required = false) String pesel,
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName) {
        return patientRepository.findByIdOrFirstNameOrLastNameOrPesel(id, firstName, lastName, pesel);
    }

    @PostMapping("/newPatient")
    public String newPatient(@RequestBody @Valid Patient newPatient) {
        patientRepository.save(newPatient);
        return "New " + newPatient.toString();
    }

    @GetMapping("/test")
    public String txt() {
        return "test";
    }
}
