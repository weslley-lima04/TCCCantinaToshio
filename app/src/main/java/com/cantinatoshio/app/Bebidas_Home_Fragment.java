package com.cantinatoshio.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Bebidas_Home_Fragment extends Fragment
{

    ListView lista_bebidas;

    String [] nomeProduto = {"Suco natural", "Refrigerante", "Água"};
    String [] descProduto = {"Vários sabores", "Vários sabores", "Sem gás"};
    String [] precoProduto = {"5,00", "5,00", "2,00"};
    String [] qtdeProduto = {"0", "0", "0"};
    int[] imgProduto = {R.drawable.suco, R.drawable.refri, R.drawable.agua};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bebidas_home, container, false);
        lista_bebidas = v.findViewById(R.id.lista_bebidas);
        AdapterBebidas adapterBebidas = new AdapterBebidas();
        lista_bebidas.setAdapter(adapterBebidas);



        return v;
    }

    private class AdapterBebidas extends BaseAdapter
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
            View v = getLayoutInflater().inflate(R.layout.modelo_produtos, null);

            //produtoCardView = v.findViewById(R.id.cardProduto);
            txtnomeProduto = v.findViewById(R.id.nomeProduto);
            txtdescProduto = v.findViewById(R.id.descricao);
            txtprecoProduto = v.findViewById(R.id.preco);
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