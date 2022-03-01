package hello.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/Hello")
    public String getHello() {
        return "Hello, Nefty!";
    }
}
