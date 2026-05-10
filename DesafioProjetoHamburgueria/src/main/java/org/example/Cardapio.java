package org.example;

public class Cardapio {

    private ItemCardapio itemCardapio;

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public String getCardapio() {
        if (this.itemCardapio == null) {
            throw new NullPointerException("Cardápio não pode ser nulo");
        }
        return this.itemCardapio.getConteudo();
    }

}