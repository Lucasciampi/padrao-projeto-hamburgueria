package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    private Atendimento atendimento;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        atendimento = new Atendimento();
        pedido = new Pedido(LancheEspecialFactory.getInstance());
    }

    @Test
    void devePrepararPedido() {
        Tarefa prepararPedido = new PrepararPedidoTarefa(pedido);
        atendimento.executarTarefa(prepararPedido);
        assertEquals("Em Preparação", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarPedido() {
        pedido.preparar();
        Tarefa cancelarPedido = new CancelarPedidoTarefa(pedido);
        atendimento.executarTarefa(cancelarPedido);
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarUltimaTarefaDePreparo() {
        Tarefa prepararPedido = new PrepararPedidoTarefa(pedido);
        atendimento.executarTarefa(prepararPedido);
        atendimento.cancelarUltimaTarefa();
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveDesfazerCancelamento() {
        pedido.preparar();
        Tarefa cancelarPedido = new CancelarPedidoTarefa(pedido);
        atendimento.executarTarefa(cancelarPedido);
        atendimento.cancelarUltimaTarefa();
        assertEquals("Cancelado", pedido.getNomeEstado()); // continua cancelado, irreversível
    }

    @Test
    void naoDeveLancarExcecaoAoCancelarSemTarefas() {
        atendimento.cancelarUltimaTarefa();
        assertEquals("Aceito", pedido.getNomeEstado());
    }

}