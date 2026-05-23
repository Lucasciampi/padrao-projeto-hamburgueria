package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
    }


    @Test
    void deveRealizarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha recebeu o pedido: X-Bacon",
                cliente.realizarPedido("X-Bacon"));
    }

    @Test
    void deveCancelarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha cancelou o pedido: X-Bacon",
                cliente.cancelarPedido("X-Bacon"));
    }

    @Test
    void deveVerificarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha verificou o pedido: X-Bacon",
                cliente.verificarPedido("X-Bacon"));
    }

}