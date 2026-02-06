package ch.maxim.rbac_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    // .\mvnw.cmd spring-boot:run
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }   
}

