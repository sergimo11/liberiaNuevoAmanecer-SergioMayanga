package com.example.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit_1, edit2, edit3, edit4, editT5, editT6, edit7, editT;

    Button button, button2, button3, button4, btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_1 = findViewById(R.id.edit_1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        editT5 = findViewById(R.id.editT5);
        editT6 = findViewById(R.id.editT6);
        edit7 = findViewById(R.id.edit7);
        editT = findViewById(R.id.editT);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        btnBuscar = findViewById(R.id.button5);

        final libroTools javatoll = new libroTools(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                javatoll.REGISTRAR(edit_1.getText().toString(), edit2.getText().toString(), edit3.getText().toString(), edit4.getText().toString(),
                        editT5.getText().toString(), editT6.getText().toString(), edit7.getText().toString());
                edit_1.getText().clear();
                edit2.getText().clear();
                edit3.getText().clear();
                edit4.getText().clear();
                editT5.getText().clear();
                editT6.getText().clear();
                edit7.getText().clear();
                editT.getText().clear();
                Toast.makeText(getApplicationContext(), "DATOS DEL LIBRO SE AGREGARON CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

        //BOTON MOSTRAR


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mostrarlibro = new Intent(getApplicationContext(), libriando.class);
                startActivity(Mostrarlibro);
            }
        });


       btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                libroverse pels = new libroverse();
                javatoll.Buscralibro(pels, editT.getText().toString());


                edit_1.setText(pels.getCodigo());
                edit2.setText(pels.getLibro());
                edit3.setText(pels.getPais());
                edit4.setText(pels.getPaginas());
                editT5.setText(pels.getGenero());
                editT6.setText(pels.getDirector());
                edit7.setText(pels.getEditorial());



            }

        });




        //BOTON EDITAR

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                javatoll.Editarlibro(editT.getText().toString(),edit2.getText().toString(), edit3.getText().toString(), edit4.getText().toString(),
                        editT5.getText().toString(), editT6.getText().toString(), edit7.getText().toString());



            }

        });

        //BOTON BOORAR

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                javatoll.ELIMINAR(editT.getText().toString());

                editT.getText().clear();
                edit_1.getText().clear();
                edit2.getText().clear();
                edit3.getText().clear();
                edit4.getText().clear();
                editT5.getText().clear();
                editT6.getText().clear();
                edit7.getText().clear();
                Toast.makeText(getApplicationContext(),"EL LIBRO SE ELIMIN?? CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });

    }
}