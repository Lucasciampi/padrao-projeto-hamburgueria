package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoriaCardapio extends ItemCardapio implements Iterable<ItemCardapio> {

    private List<ItemCardapio> items = new ArrayList<>();

    public CategoriaCardapio(String descricao) {
        super(descricao);
    }

    public void addItem(ItemCardapio item) {
        this.items.add(item);
    }

    @Override
    public String getConteudo() {
        String conteudo = "Categoria: " + getDescricao() + "\n";
        for (ItemCardapio item : items) {
            conteudo += item.getConteudo();
        }
        return conteudo;
    }

    @Override
    public Iterator<ItemCardapio> iterator() {
        return items.iterator();
    }

}
