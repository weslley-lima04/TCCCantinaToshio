package com.cantinatoshio.app;

import com.cantinatoshio.app.api.Api;
import com.cantinatoshio.app.api.PerformNetworkRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente
{

    int idCliente = 1;
    String nomeCliente;
    String emailCliente;
    String telefoneCliente;
    String senhaCliente;
    static ArrayList<Pedido> pedidos;
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;


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



    public void setPedidos(ArrayList<Pedido> pedidos)
    {
        this.pedidos = pedidos;
    }

    public static ArrayList<Pedido> getPedidos()
    {
        return pedidos;
    }

    public void getPedidosCliente()
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("IDCliente",String.valueOf(this.idCliente));
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CLIENTE_PEDIDOS, params, CODE_POST_REQUEST);
        try
        {
            request.execute();
        }
        catch (Exception e)
        {
            System.out.println("ERRO");
        }

    }



}
