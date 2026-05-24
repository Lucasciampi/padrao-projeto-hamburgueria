package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private List<Pedido> historico = new ArrayList<>();

    public void registrarPedido(Pedido pedido) {
        this.historico.add(pedido);
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
