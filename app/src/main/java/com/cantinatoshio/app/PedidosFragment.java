package com.cantinatoshio.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;*/


public class PedidosFragment extends Fragment
{
    ListView listapedidos;

    //arrays a serem usados na lista
    String[] datapedido = {gerarData()};
    //String[] horapedido = {"22:05"};
    String[] idpedido = {"0000"};
    String[] status = {"Finalizado"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_pedidos, container, false);
      listapedidos = view.findViewById(R.id.lst_pedidos);
      AdapterPedidos adapterPedidos = new AdapterPedidos();

      listapedidos.setAdapter(adapterPedidos);

      //clique pra abrir nova janela
      listapedidos.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
          {
              //pedindo pra abrir nova janela
              Intent intent = new Intent(getContext(), ClickPedidosActivity.class);
              //colocando itens nela
              intent.putExtra("dataPedido", datapedido[i]);
              //intent.putExtra("horaPedido", horapedido[i]);
              intent.putExtra("idPedido", idpedido[i]);
              intent.putExtra("statusPedido", status[i]);

              startActivity(intent);


          }
      });

      return view;
    }

    //adaptador de pedidos como classe interna

    public class AdapterPedidos extends BaseAdapter{

        @Override
        public int getCount()
        {
            return status.length;
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
            TextView txtdataPedido, txthoraPedido, txtPedido, txtidPedido, txtStatus, txtAvalie;
            View v = getLayoutInflater().inflate(R.layout.modelo_pedido_realizado, null);

            txtdataPedido = v.findViewById(R.id.txt_dataPedido);
            //txthoraPedido = v.findViewById(R.id.txt_horaPedido);
            txtPedido = v.findViewById(R.id.txt_Pedido);
            txtidPedido = v.findViewById(R.id.txt_idPedido);
            txtStatus = v.findViewById(R.id.txt_Status);
            txtAvalie = v.findViewById(R.id.txt_Avalie);

            txtdataPedido.setText(datapedido[i]);
            //txthoraPedido.setText(horapedido[i]);
            //txtidPedido.setText(idpedido[i]);
            txtStatus.setText(status[i]);


            return v;
        }


    }

    public String gerarData()
    {
        //SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DateFormat formatter= DateFormat.getDateTimeInstance();
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


}