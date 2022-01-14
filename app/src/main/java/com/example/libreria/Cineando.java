package com.example.libreria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Cineando extends AppCompatActivity {
    private RecyclerView reciclerCinema;
    private RecicleViuwAdapter AdapterCinema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cine);


        reciclerCinema=findViewById(R.id.pelicula);
        reciclerCinema.setLayoutManager(new LinearLayoutManager(this));
JavaToll javaToll=new JavaToll(getApplicationContext());
AdapterCinema=new RecicleViuwAdapter(javaToll.MostrarPeliculas());
reciclerCinema.setAdapter(AdapterCinema);



    }

}