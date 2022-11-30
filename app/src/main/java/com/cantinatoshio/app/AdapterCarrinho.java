package com.cantinatoshio.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.cantinatoshio.app.Database.PedidoHelper;

import java.util.ArrayList;

public class AdapterCarrinho extends RecyclerView.Adapter<AdapterCarrinho.ViewHolder>
{

    private ArrayList<Produto> carrinho;
    private Context context;

   // public AdapterCarrinho(){}

    public AdapterCarrinho(Context context, ArrayList<Produto> carrinho)
    {
        this.carrinho = carrinho;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_produtos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.midProduto.setText(carrinho.get(position).getIdProduto());
        holder.mnomeProduto.setText(carrinho.get(position).getNomeProduto());
        holder.mdescProduto.setText(carrinho.get(position).getDescProduto());
        holder.mprecoProduto.setText(carrinho.get(position).getPrecoProduto());
        holder.mqtdProduto.setText(carrinho.get(position).getQtdeProduto());
        holder.mImageProduto.setImageResource(carrinho.get(position).getImgProduto());
    }

    @Override
    public int getItemCount()
    {
        return carrinho.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mnomeProduto, mdescProduto, mprecoProduto, mqtdProduto, midProduto;
        ImageView mImageProduto, mdeleteProduto;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            midProduto = itemView.findViewById(R.id.IDproduto_cart);
            mnomeProduto = itemView.findViewById(R.id.nomeProduto);
            mdescProduto = itemView.findViewById(R.id.descProduto);
            mprecoProduto = itemView.findViewById(R.id.precoProduto);
            mqtdProduto = itemView.findViewById(R.id.qtdProduto);
            mImageProduto = itemView.findViewById(R.id.imgProduto);
            mdeleteProduto = itemView.findViewById(R.id.delete_item);

            mdeleteProduto.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    new PedidoHelper(context.getApplicationContext()).removerItem(midProduto.getText().toString(), view);
                }
            });
        }
    }
}
