package com.paulocandido.atendimento.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paulocandido.atendimento.model.Cliente;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    Long lastId = 0L;
    Map<Long, Cliente> dados = new HashMap<>();

    @GetMapping("clientes")
    public List<Cliente> consultaCliente(){
            return new ArrayList<>(dados.values());
    }

    @GetMapping("clientes/{id}")
    public Cliente getById(@PathVariable Long id){
        return dados.get(id);
    }

    @PostMapping("clientes")
    public Cliente incluirCliente(@RequestBody Cliente body){
        body.setId(++lastId);
        dados.put(body.getId(), body);
        return body;
    }

    @PutMapping("clientes/{id}")
    public Cliente atualizarCliente(@RequestBody Cliente body, @PathVariable Long id){
        dados.put(id, body);
        return body;
    }

    @DeleteMapping("clientes/{id}")
    public void removeCliente(@PathVariable Long id){
        dados.remove(id);
    }

}