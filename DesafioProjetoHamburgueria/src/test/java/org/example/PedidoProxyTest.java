package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PedidoProxyTest {

    @BeforeEach
    void setUp() {
        BD.limpar();
        BD.addPedido(1, new Pedido(LancheBasicoFactory.getInstance()));
        BD.addPedido(2, new Pedido(LancheEspecialFactory.getInstance()));
    }

    @Test
    void deveRetornarDadosPedido() {
        PedidoProxy pedido = new PedidoProxy(1);

        assertEquals(Arrays.asList("Hamburguer Basico: Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface + Tomate", "Aceito"),
                pedido.obterDadosPedido());
    }

    @Test
    void deveRetornarValorPagamentoPedido() {
        Funcionario funcionario = new Funcionario("Ana", true);
        PedidoProxy pedido = new PedidoProxy(2);

        assertEquals(27.0, pedido.obterValorPagamento(funcionario));
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizado() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            PedidoProxy pedido = new PedidoProxy(2);

            pedido.obterValorPagamento(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

}