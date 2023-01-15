package com.example.partagedonnee.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.partagedonnee.R;

public class CmdHolder extends RecyclerView.ViewHolder {
    TextView nameCli, products, prix;

    public CmdHolder(@NonNull View itemView) {
        super(itemView);
        nameCli = itemView.findViewById(R.id.ListItem_nameCli);
        products = itemView.findViewById(R.id.ListItem_products);
        prix = itemView.findViewById(R.id.ListItem_prix);
    }
}
