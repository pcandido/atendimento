package com.paulocandido.atendimento.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.paulocandido.atendimento.model.Cliente;
import com.paulocandido.atendimento.repository.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    @MockBean
    private ClienteRepository repository;

    private Cliente buildCliente() {
        return Cliente.builder().nome("Paulo Cândido").email("pcanido@dominio.com").build();
    }

    @Test
    public void deve_incluir_um_cliente() {

        Cliente cliente = buildCliente();

        when(repository.save(cliente)).then(invoke -> {
            Cliente creating = invoke.getArgument(0);
            creating.setId(1L);
            return creating;
        });

        Cliente created = service.create(cliente);

        assertNotNull(created);
        assertEquals(cliente.getNome(), created.getNome());
        assertEquals(cliente.getEmail(), created.getEmail());
        assertNotNull(created.getId());

    }

    @Test
    public void nao_deve_salvar_clientes_com_email_repetido() {

        Cliente cliente = buildCliente();

        when(repository.existsByEmail(cliente.getEmail())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> service.create(cliente));

    }

    @Test
    public void deve_salvar_um_cliente_se_o_email_nao_for_repetido() {

        Cliente cliente = buildCliente();

        when(repository.existsByEmail(cliente.getEmail())).thenReturn(false);

        assertDoesNotThrow(() -> service.create(cliente));

    }

}