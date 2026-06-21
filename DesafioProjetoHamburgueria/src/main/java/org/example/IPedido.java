package org.example;

import java.util.List;

public interface IPedido {
    List<String> obterDadosPedido();
    double obterValorPagamento(Funcionario funcionario);
}
