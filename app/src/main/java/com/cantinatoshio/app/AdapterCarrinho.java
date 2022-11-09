package com.cantinatoshio.app;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCarrinho extends RecyclerView.Adapter<AdapterCarrinho.ViewHolder>
{
    private Context context;
    private List<Carrinho> carrinhoList;

    public AdapterCarrinho(Context context, List<Carrinho> carrinhoList)
    {
        this.context = context;
        this.carrinhoList = carrinhoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_produtos, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        //terminar
    }

    @Override
    public int getItemCount() {
        return carrinhoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        CardView cardProduto;
        TextView descricao, titulo, preco, qtd;
        ImageView imgProduto;




        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            cardProduto = itemView.findViewById(R.id.cardViewt);
            descricao = itemView.findViewById(R.id.descProduto);
            titulo = itemView.findViewById(R.id.nomeProduto);
            preco = itemView.findViewById(R.id.precoProduto);
            qtd = itemView.findViewById(R.id.qtdProduto);
            imgProduto = itemView.findViewById(R.id.imgProduto);
        }
    }
}
