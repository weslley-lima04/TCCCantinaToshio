package com.cantinatoshio.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Doces_Home_Fragment extends Fragment
{

    ListView lista_doces;

    String [] nomeProduto = {"Fatia de bolo", "Brigadeiro", "Mousse de chocolate"};
    String [] descProduto = {"Bolo de chocolate com morango", "Chocolate com granulados", "Mousse de chocolate"};
    String [] precoProduto = {"6.00", "2.00", "10.00"};
    String [] qtdeProduto = {"0", "0", "0"};
    int[] imgProduto = {R.drawable.bolo, R.drawable.brigadeiro, R.drawable.mousse};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doces_home, container, false);
        lista_doces = v.findViewById(R.id.lista_doces);
        AdapterDoces adapterDoces = new AdapterDoces();
        lista_doces.setAdapter(adapterDoces);

        //aqui o click
        lista_doces.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getContext(), ClickDocesActivity.class);
                intent.putExtra("nomeProduto", nomeProduto[i]);
                intent.putExtra("descProduto", descProduto[i]);
                intent.putExtra("precoProduto", precoProduto[i]);
                intent.putExtra("qtdeProduto", qtdeProduto[i]);
                intent.putExtra("imgProduto", imgProduto[i]);
                startActivity(intent);
            }
        });



        return v;
    }

    private class AdapterDoces extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return imgProduto.length;
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            TextView txtnomeProduto, txtdescProduto, txtprecoProduto, txtqtdeProduto;
            ImageView modelimgProduto;
            View v = getLayoutInflater().inflate(R.layout.modelo_feed, null);

            //produtoCardView = v.findViewById(R.id.cardProduto);
            txtnomeProduto = v.findViewById(R.id.nomeProduto);
            txtdescProduto = v.findViewById(R.id.descProduto);
            txtprecoProduto = v.findViewById(R.id.precoProduto);
            txtqtdeProduto = v.findViewById(R.id.qtdProduto);
            modelimgProduto = v.findViewById(R.id.imgProduto);

            txtnomeProduto.setText(nomeProduto[i]);
            txtdescProduto.setText(descProduto[i]);
            txtprecoProduto.setText(precoProduto[i]);
            txtqtdeProduto.setText(qtdeProduto[i]);
            modelimgProduto.setImageResource(imgProduto[i]);

            return v;
        }
    }
}