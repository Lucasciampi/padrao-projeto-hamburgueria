package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrecoAdapterTest {

    private IPreco precoBRL;
    private PrecoAdapter adapter;

    @BeforeEach
    void setUp() {
        precoBRL = new PrecoBRL();
        adapter = new PrecoAdapter(precoBRL);
    }

    @Test
    void deveConverterRealParaPontos() {
        precoBRL.setPreco(27.0);
        adapter.salvarPreco();
        assertEquals(270, adapter.getPontos());
    }

    @Test
    void deveConverterPontosParaReal() {
        adapter.setPontos(145);
        assertEquals(14.5, adapter.recuperarPreco());
    }

}