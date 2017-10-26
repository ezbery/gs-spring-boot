package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/test")
    public String txt() {
        return "test";
    }
}
