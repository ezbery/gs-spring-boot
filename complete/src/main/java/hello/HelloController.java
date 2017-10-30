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
    public List<Patient> returnPatientById(
            @RequestParam(name = "id", required = false) Long id) {
        List<Patient> patientById = patientRepository.findById(id);
        return patientById;
    }


    @PostMapping("/newPatient")
    public String newPatient(@RequestBody @Valid Patient newPatient) {
        patientRepository.save(newPatient);
        return "created new patient: " + newPatient.toString();
    }

    @GetMapping("/test")
    public String txt() {
        return "test";
    }
}
