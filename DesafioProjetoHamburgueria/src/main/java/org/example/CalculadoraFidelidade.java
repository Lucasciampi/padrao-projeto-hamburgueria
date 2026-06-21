package org.example;

public class CalculadoraFidelidade {

    public static int calcularPontos(Pedido pedido) {
        IPreco precoBRL = new PrecoBRL();
        precoBRL.setPreco(pedido.getValorTotal());
        PrecoAdapter precoAdapter = new PrecoAdapter(precoBRL);
        precoAdapter.salvarPreco();
        return precoAdapter.getPontos();
    }
}
