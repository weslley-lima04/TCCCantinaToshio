package com.cantinatoshio.app;

import com.cantinatoshio.app.api.Api;
import com.cantinatoshio.app.api.PerformNetworkRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente
{
    public static boolean isLoggedIn;
    public static int idCliente;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String senhaCliente;
    static ArrayList<Pedido> pedidos;
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;


    public static void setIdCliente(int idCliente)
    {
        Cliente.idCliente = idCliente;
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
            System.out.println("Erro ao carregar pedidos.");
        }

    }

    public void logar(String email, String senha)
    {
        System.out.println("FUNÇÃO LOGAR EXECUTADA");
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("senha",senha);
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_LOGAR, params, CODE_POST_REQUEST);
        try
        {
            request.execute();
        }
        catch (Exception e)
        {
            System.out.println("Erro ao logar");
        }
    }



}
