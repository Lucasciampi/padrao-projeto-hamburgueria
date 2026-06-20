package org.example;

public class PrepararPedidoTarefa implements Tarefa {

    private Pedido pedido;

    public PrepararPedidoTarefa(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        this.pedido.preparar();
    }

    @Override
    public void cancelar() {
        this.pedido.cancelar();
    }

}
