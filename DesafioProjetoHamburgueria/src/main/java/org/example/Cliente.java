package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private List<Pedido> historico = new ArrayList<>();
    private int saldoPontos = 0;
    private List<SaldoPontosMemento> historicoSaldo = new ArrayList<>();

    public void registrarPedido(Pedido pedido) {
        this.historico.add(pedido);
        this.saldoPontos += CalculadoraFidelidade.calcularPontos(pedido);
    }

    public void usarPontos(int pontos) {
        if (pontos > this.saldoPontos) {
            throw new IllegalArgumentException("Saldo de pontos insuficiente");
        }
        salvarSaldo();
        this.saldoPontos -= pontos;
    }

    public void salvarSaldo() {
        this.historicoSaldo.add(new SaldoPontosMemento(this.saldoPontos));
    }

    public void desfazerUsoPontos() {
        if (this.historicoSaldo.isEmpty()) {
            throw new IllegalStateException("Não há saldo anterior para restaurar");
        }
        SaldoPontosMemento memento = this.historicoSaldo.remove(this.historicoSaldo.size() - 1);
        this.saldoPontos = memento.getSaldo();
    }

    public int getSaldoPontos() {
        return saldoPontos;
    }

    public Pedido repetirPedido(int indice) throws CloneNotSupportedException {
        if (indice < 0 || indice > this.historico.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return this.historico.get(indice).clone();
    }

    public List<Pedido> getHistorico() {
        return this.historico;
    }

}
