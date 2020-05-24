package com.paulocandido.atendimento;

public class Classe3 {

    private String mensagem;
    private ClasseInjetavel ci;

    public Classe3(String mensagem, ClasseInjetavel ci){
        this.mensagem = mensagem;
        this.ci = ci;
    }

    public String process(){
        return this.mensagem + " - " + ci.process();
    }
    
}