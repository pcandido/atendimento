package com.paulocandido.atendimento;

public class Classe2 {

    private Classe3 c3;

    public Classe2(Classe3 c3) {
        this.c3 = c3;
    }

    public String process() {
        return "c2 - " + c3.process();
    }

}