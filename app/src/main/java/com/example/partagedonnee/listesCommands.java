package com.example.partagedonnee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.partagedonnee.adapter.CommandAdapter;
import com.example.partagedonnee.model.CommandeEntity;
import com.example.partagedonnee.retrofit.CommandeApi;
import com.example.partagedonnee.retrofit.RetrofitServices;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listesCommands extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listes_commands);

        recyclerView = findViewById(R.id.commandsList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        CommandAdapter commandAdapter = new CommandAdapter();
//        recyclerView.setAdapter(commandAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.commandsList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, Welcome.class);
            startActivity(intent);
        });
        loadCommands();
    }

    private void loadCommands() {
        RetrofitServices retrofitService = new RetrofitServices();
        CommandeApi commandeApi = retrofitService.getRetrofit().create(CommandeApi.class);
        commandeApi.getAll()
                .enqueue(new Callback<List<CommandeEntity>>() {
                    @Override
                    public void onResponse(Call<List<CommandeEntity>> call, Response<List<CommandeEntity>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CommandeEntity>> call, Throwable t) {
                        Toast.makeText(listesCommands.this, "Failed to load commands", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<CommandeEntity> commandsList) {
        CommandAdapter commandAdapter = new CommandAdapter(commandsList);
        recyclerView.setAdapter(commandAdapter);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        loadCommands();
//    }

}
