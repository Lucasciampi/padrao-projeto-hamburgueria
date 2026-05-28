package org.example;

import java.util.Iterator;

public class ResumoCardapio {

    public static Integer contarItensAcimaDe(CategoriaCardapio categoriaCardapio, double preco){
        int quantidade = 0;
        for (ItemCardapio item : categoriaCardapio){
            if (item instanceof ItemSimples){
                if (((ItemSimples) item).getPreco() > preco) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }


    public static Integer contarTotalItens(CategoriaCardapio categoriaCardapio){
        int quantidade  = 0;
        for (Iterator<ItemCardapio> i = categoriaCardapio.iterator(); i.hasNext(); ) {
            quantidade  ++;
            i.next();
        }
        return quantidade ;
    }

}
