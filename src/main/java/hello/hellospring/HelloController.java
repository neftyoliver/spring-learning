package hello.hellospring;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("")
    public String getDefault() {
        return "Hello, world!";
    }

    @GetMapping("/{value}")
    public String getUrlToView(@PathVariable("value") String value) {
        return value;
    }
}
