package com.cantinatoshio.app;

import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Produto> itens;

    public void AdicionaItem(Produto produto)
    {
        this.itens.add(produto);
    }

    public double CalculaTotal()
    {
        double total = 0;


        for (Produto i : this.itens)
        {
            total += i.getPrecoProduto();
        }

        return total;
    }


}
