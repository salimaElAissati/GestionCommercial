package com.example.partagedonnee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.partagedonnee.model.CommandeEntity;
import com.example.partagedonnee.retrofit.CommandeApi;
import com.example.partagedonnee.retrofit.RetrofitServices;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditProd = findViewById(R.id.form_textFieldProd);
        TextInputEditText inputEditPrice = findViewById(R.id.form_textFieldPrice);
        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitServices retrofitService = new RetrofitServices();
        CommandeApi commandeApi = retrofitService.getRetrofit().create(CommandeApi.class);

        buttonSave.setOnClickListener(view -> {
            String nameCli = String.valueOf(inputEditTextName.getText());
            String products = String.valueOf(inputEditProd.getText());
            String price = String.valueOf(inputEditPrice.getText());

            CommandeEntity commande = new CommandeEntity();
            commande.setNameCli(nameCli);
            commande.setProducts(products);
            commande.setPrix(price);

            commandeApi.save(commande)
                    .enqueue(new Callback<CommandeEntity>() {
                        @Override
                        public void onResponse(Call<CommandeEntity> call, Response<CommandeEntity> response) {
                            Toast.makeText(Welcome.this, "Save successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<CommandeEntity> call, Throwable t) {
                            Toast.makeText(Welcome.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });
    }
}