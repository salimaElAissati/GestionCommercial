package com.example.partagedonnee.retrofit;

import com.example.partagedonnee.model.CommandeEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CommandeApi {
    @GET("commands/allList")
    Call<List<CommandeEntity>> getAll();

    @POST("commands/save")
    Call<CommandeEntity> save(@Body CommandeEntity commande);
}
