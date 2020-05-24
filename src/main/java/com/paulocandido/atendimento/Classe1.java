package com.paulocandido.atendimento;

import org.springframework.stereotype.Component;

@Component
public class Classe1 {

    private Interface2 i2;

    public Classe1(Interface2 i2){
        this.i2 = i2;
    }
    
    public String process(){
        return "c1 - " + i2.process();
    }

}