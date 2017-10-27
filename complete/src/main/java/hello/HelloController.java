package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/{variable}")
    public String index2(@PathVariable String variable) {
        UserRepository repository = null;
        Userer user = new Userer(variable);
        repository.save(user);
        return "response: " + variable + "id: " + user.getId();
    }

    @GetMapping("/test")
    public String txt() {
        return "test";
    }
}
