package com.cantinatoshio.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        RecyclerView lista_carrinho;
        List<Carrinho> carrinho;

        getLayoutInflater().inflate(R.layout.activity_carrinho, null);
        lista_carrinho = findViewById(R.id.lista_carrinho);

        //aqui vem o ArrayList com os itens do carrinho a serem adicionados

        //itens = new ArrayList<>();


        //Aqui vem a declaração do adapter


        lista_carrinho.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        lista_carrinho.hasFixedSize();


        //aqui vem o set adapter

    }
}