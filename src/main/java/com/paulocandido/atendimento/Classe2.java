package com.paulocandido.atendimento;

import org.springframework.stereotype.Component;

@Component
public class Classe2 implements Interface2 {

    private Classe3 c3;

    public Classe2(Classe3 c3) {
        this.c3 = c3;
    }

    public String process() {
        return "c2 - " + c3.process();
    }

}