package com.cantinatoshio.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickDocesActivity extends AppCompatActivity
{

    TextView nomeProduto, precoProduto, qtdeProduto, descProduto;
    ImageView imgProduto;

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

        Intent intent = getIntent();

        nomeProduto.setText(intent.getStringExtra("nomeProduto"));
        precoProduto.setText(intent.getStringExtra("precoProduto"));
        qtdeProduto.setText(intent.getStringExtra("qtdeProduto"));
        descProduto.setText(intent.getStringExtra("descProduto"));
        imgProduto.setImageResource(intent.getIntExtra("imgProduto", 0));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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