package com.cantinatoshio.app;

import java.util.ArrayList;

public class Cliente
{

    int idCliente = 1;
    String nomeCliente;
    String emailCliente;
    String telefoneCliente;
    String senhaCliente;
    static ArrayList<Pedido> pedidos;


    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public String getNomeCliente()
    {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente)
    {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente()
    {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente)
    {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente()
    {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente)
    {
        this.telefoneCliente = telefoneCliente;
    }

    public String getSenhaCliente()
    {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente)
    {
        this.senhaCliente = senhaCliente;
    }

    public ArrayList<Pedido> getPedidos()
    {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos)
    {
        this.pedidos = pedidos;
    }
}
