package com.paulocandido.atendimento.repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import com.paulocandido.atendimento.model.Cliente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:db/data.sql")
public class ClienteRepositoryTest {

    private final String EXAMPLE_NOME = "Larissa";
    private final String EXAMPLE_EMAIL = "larissa@dominio.com";

    private ClienteRepository repository;

    @Autowired
    public ClienteRepositoryTest(ClienteRepository repository) {
        this.repository = repository;
    }

    private Cliente buildCliente() {
        return Cliente.builder().nome(EXAMPLE_NOME).email(EXAMPLE_EMAIL).build();
    }

    @Test
    public void deve_buscar_todos_os_clientes() {
        List<Cliente> clientes = repository.findAll(Sort.by("id"));
        assertEquals(10, clientes.size());
        assertArrayEquals(new Long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L },
                clientes.stream().map(Cliente::getId).toArray());
    }

    @Test
    public void deve_inserir_um_novo_cliente() {
        Cliente cliente = buildCliente();

        repository.save(cliente);
        assertEquals(11L, cliente.getId());

        Cliente saved = repository.findById(11L).get();
        assertEquals(EXAMPLE_NOME, saved.getNome());
    }

    @Test
    public void deve_editar_um_cliente_existente() {
        Cliente cliente = buildCliente();
        cliente.setId(2L);

        repository.save(cliente);

        Cliente saved = repository.findById(2L).get();
        assertEquals(EXAMPLE_NOME, saved.getNome());
    }

    @Test
    public void deve_remover_um_cliente() {
        repository.deleteById(4L);
        assertFalse(repository.findById(4L).isPresent());
    }
}