package com.digrutt.course_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoControler {

    //http://localhost:8080/saludar/hola
    @GetMapping("/hola")
    public String saludar(){
        return "Hello World";
    }
}
