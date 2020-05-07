package com.paulocandido.atendimento.controllers;

import java.util.List;

import com.paulocandido.atendimento.model.Cliente;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("clientes")
    public List<Cliente> consultaCliente(@RequestParam String sort){
            return List.of(
                new Cliente(1L, "Paulo", "paulo@dominio.com"),
                new Cliente(2L, sort, "ana@dominio.com")
            );
    }

    @GetMapping("clientes/{id}")
    public Cliente getById(@PathVariable Long id){
        return new Cliente(id, "Paulo", "paulo@dominio.com");
    }

    @PostMapping("clientes")
    public Cliente incluirCliente(@RequestBody Cliente body){
        body.setId(5L);
        return body;
    }

    @PutMapping("clientes/{id}")
    public Cliente atualizarCliente(@RequestBody Cliente body, @PathVariable Long id){
        body.setId(id);
        return body;
    }

    @DeleteMapping("clientes/{id}")
    public void removeCliente(@PathVariable Long id){
        System.out.println(id);
    }

}