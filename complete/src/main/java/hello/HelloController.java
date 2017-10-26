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
        return "response: " + variable;
    }

    @GetMapping("/test")
    public String txt() {
        return "test";
    }
}
