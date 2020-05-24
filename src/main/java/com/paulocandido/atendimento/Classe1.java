package com.paulocandido.atendimento;

import org.springframework.stereotype.Component;

@Component
public class Classe1 {

    private Classe2 c2;

    public Classe1(Classe2 c2){
        this.c2 = c2;
    }
    
    public String process(){
        return "c1 - " + c2.process();
    }

}