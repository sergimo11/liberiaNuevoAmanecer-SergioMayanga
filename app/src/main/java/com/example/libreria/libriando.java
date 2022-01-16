package com.example.libreria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class libriando extends AppCompatActivity {
    private RecyclerView reciclerlibriando;
    private RecicleViuwAdapter Adapterlibriando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libro);


        reciclerlibriando=findViewById(R.id.pelicula);
        reciclerlibriando.setLayoutManager(new LinearLayoutManager(this));
libroTools javaToll=new libroTools(getApplicationContext());
Adapterlibriando=new RecicleViuwAdapter(javaToll.Mostrarlibro());
reciclerlibriando.setAdapter(Adapterlibriando);



    }

}