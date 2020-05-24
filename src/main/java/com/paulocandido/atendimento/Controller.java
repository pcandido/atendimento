package com.paulocandido.atendimento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Classe1 c1;
    private ClasseInjetavel ci;

    public Controller(ClasseInjetavel ci, Classe1 c1){
        this.c1 = c1;
        this.ci = ci;
    }

    @GetMapping
    public String teste(){
        return String.format("%s\n%s\n", c1.process(), ci.process());
    }

    
}