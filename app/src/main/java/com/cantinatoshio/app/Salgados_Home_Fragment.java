package com.cantinatoshio.app;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class Salgados_Home_Fragment extends Fragment
{

    ListView lista_salgados;

    String [] nomeProduto = {"Coxinha", "Pão de Queijo", "Misto Quente"};
    String [] descProduto = {"Frango com catupiry", "Quente e crocante", "Com queijo e presunto"};
    String [] precoProduto = {"6,00", "2,50", "6,00"};
    String [] qtdeProduto = {"0", "0", "0"};
    int[] imgProduto = {R.drawable.coxinha, R.drawable.fpaodequeijo, R.drawable.misto};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salgados_home, container, false);
        lista_salgados = view.findViewById(R.id.lista_salgados);
        AdapterSalgados adapterSalgados = new AdapterSalgados();
        lista_salgados.setAdapter(adapterSalgados);


        //aqui vem o clique pra nova janela

        lista_salgados.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getContext(), "Funcionando", Toast.LENGTH_SHORT).show();
            }
        });
        //teste


        return view;
    }

    public class AdapterSalgados extends BaseAdapter
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
            CardView produtoCardView;
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