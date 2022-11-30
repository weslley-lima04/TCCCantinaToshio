package com.cantinatoshio.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PedidoRealizado extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_realizado);
        textView = findViewById(R.id.num_pedido);
        //System.out.println("SAIDA DO ID PEDIDO");
        //System.out.println(Pedido.idPedido);
        textView.setText("#00" + String.valueOf(Pedido.idPedido + 1));

    }
}