package com.cantinatoshio.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickDocesActivity extends AppCompatActivity
{
    //para o click

    int qtdProd;


    TextView nomeProduto, precoProduto, qtdeProduto, descProduto;
    ImageView imgProduto, clickMais, clickMenos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_produto);

        nomeProduto = findViewById(R.id.txtNomeProduto);
        precoProduto = findViewById(R.id.valorProduto);
        qtdeProduto = findViewById(R.id.qtdeProduto);
        descProduto = findViewById(R.id.contentDescricao);
        imgProduto = findViewById(R.id.imagemProduto);
        clickMais = findViewById(R.id.clickProdutobtnMais);
        clickMenos = findViewById(R.id.clickProdutobtnMenos);

        Intent intent = getIntent();

        nomeProduto.setText(intent.getStringExtra("nomeProduto"));
        precoProduto.setText(intent.getStringExtra("precoProduto"));
        qtdeProduto.setText(intent.getStringExtra("qtdeProduto"));
        descProduto.setText(intent.getStringExtra("descProduto"));
        imgProduto.setImageResource(intent.getIntExtra("imgProduto", 0));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //mudar quantidade e valor
        //inicializando valor do produto
        double valorProd = Double.parseDouble(String.valueOf(precoProduto.getText()));

        clickMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double valModProd = valorProd;
                qtdProd = Integer.parseInt(String.valueOf(qtdeProduto.getText()));
                qtdProd++;
                valModProd = valModProd*qtdProd;
                qtdeProduto.setText(String.valueOf(qtdProd));
                precoProduto.setText(String.valueOf(valModProd));
            }

        });


        clickMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double valModProd = valorProd;
                qtdProd = Integer.parseInt(String.valueOf(qtdeProduto.getText()));
                if (qtdProd>0)
                {
                    qtdProd--;
                }
                valModProd = valModProd*qtdProd;
                qtdeProduto.setText(String.valueOf(qtdProd));
                precoProduto.setText(String.valueOf(valModProd));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}