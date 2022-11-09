package com.cantinatoshio.app;

public class Produto
{
    private String nomeProduto;
    private double precoProduto;
    private int qtdeProduto;
    private String descProduto;
    private String tipoProduto;

    public double getPrecoProduto()
    {
        return precoProduto;
    }

    public int getQtdeProduto()
    {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto)
    {
        this.qtdeProduto = qtdeProduto;
    }

    public String getDescProduto()
    {
        return descProduto;
    }

    public String getNomeProduto()
    {
        return nomeProduto;
    }

    public String getTipoProduto()
    {
        return tipoProduto;
    }

    public Produto(String descProduto, String tipoProduto, String nomeProduto, double precoProduto, int qtdeProduto)
    {
        this.descProduto = descProduto;
        this.tipoProduto = tipoProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdeProduto = qtdeProduto;
    }

    public Produto(String descProduto, String nomeProduto, double precoProduto, int qtdeProduto)
    {
        this.descProduto = descProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdeProduto = qtdeProduto;
    }

}
