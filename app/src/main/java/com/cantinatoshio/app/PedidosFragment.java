package com.cantinatoshio.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/*
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;*/


public class PedidosFragment extends Fragment
{
    ListView listapedidos;

    /*
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    String data = dateFormat.format(date);

    Date data = Calendar.getInstance().getTime();*/

    //arrays a serem usados na lista
    String[] datapedido = {"20/08/2022"};
    String[] horapedido = {"00:00"};
    //int[] idpedido = {0};
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

      return view;
    }

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
            txthoraPedido = v.findViewById(R.id.txt_horaPedido);
            txtPedido = v.findViewById(R.id.txt_Pedido);
            txtidPedido = v.findViewById(R.id.txt_idPedido);
            txtStatus = v.findViewById(R.id.txt_Status);
            txtAvalie = v.findViewById(R.id.txt_Avalie);

            txtdataPedido.setText(datapedido[i]);
            txthoraPedido.setText(horapedido[i]);
            //txtidPedido.setText(idpedido[i]);
            txtStatus.setText(status[i]);


            return v;
        }
    }



}