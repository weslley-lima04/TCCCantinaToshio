package com.cantinatoshio.app.api;

public class Api
{
    private static final String ROOT_URL = "http://192.168.1.14/CantinaAPI/CantinaAPI/v1/Api.php?apicall=";

    public static final String URL_CREATE_HERO = ROOT_URL + "createProdutos";
    public static final String URL_READ_HEROES = ROOT_URL + "getProdutos";
    public static final String URL_UPDATE_HERO = ROOT_URL + "updateProdutos";
    public static final String URL_DELETE_HERO = ROOT_URL + "deleteProdutos&IDProduto=";
    public static final String URL_CREATE_PEDIDO = ROOT_URL + "createPedido";

    public static final String URL_CADASTRA_ITENS = ROOT_URL + "cadastraItens";

    public static final String URL_CLIENTE_PEDIDOS = ROOT_URL + "getClientePedidos";

    public static final String URL_LAST_IDPEDIDO = "http://192.168.1.14/CantinaApi/CantinaAPI/includes/getPedidoID.php";


    public static final String URL_LOGAR = ROOT_URL + "logar";



}
