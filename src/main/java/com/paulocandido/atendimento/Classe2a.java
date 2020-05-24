package com.paulocandido.atendimento;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Classe2a implements Interface2 {

    public String process(){
        return "c2a";
    }
    
}