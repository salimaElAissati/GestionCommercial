package com.example.partagedonnee.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.partagedonnee.R;
import com.example.partagedonnee.model.CommandeEntity;

import java.util.List;

public class CommandAdapter extends RecyclerView.Adapter<CmdHolder> {

    private List<CommandeEntity> commandsList;

//    public CommandAdapter(){};

    public CommandAdapter(List<CommandeEntity> commandsList) {
        this.commandsList = commandsList;
    }



    @NonNull
    @Override
    public CmdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_cmd, parent, false);
        return new CmdHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CmdHolder holder, int position) {
        CommandeEntity commandeEntity = commandsList.get(position);
        holder.nameCli.setText(commandeEntity.getNameCli());
        holder.products.setText(commandeEntity.getProducts());
        holder.prix.setText(commandeEntity.getPrix());

    }

    @Override
    public int getItemCount() {
        return commandsList.size();
    }
}
