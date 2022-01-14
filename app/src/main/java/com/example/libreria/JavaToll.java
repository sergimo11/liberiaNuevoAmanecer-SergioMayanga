package com.example.libreria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class JavaToll extends SQLiteOpenHelper {
    private static final String NOm_BD = "NEW STUDIO.db";
    private static final int VER_BD = 1;
    private static final String Tabla_BD = "CREATE TABLE REGISTRO(CODIGO TEXT PRIMARY KEY,PELICULA TEXT ,PAIS  TEXT, DURACION  TEXT , FECHA DE PRODUCCION  TEXT ,GENERO TEXT, DIRECTOR TEXT)";

    public JavaToll(Context context) {

        super(context, NOm_BD, null, VER_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tabla_BD);
        sqLiteDatabase.execSQL(Tabla_BD);
    }

    public void REGISTRAR(String codigo, String pelicula, String pais, String duracion, String fecha, String genero, String director) {
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null) {
            bd.execSQL("INSERT INTO REGISTRO  VALUES('" + codigo + "',  '" + pelicula + "','" + pais + "','" + duracion + "','" + fecha + "','" + genero + "','" + director + "') ");
            bd.close();
        }

    }

    public List<Cineverse> MostrarPeliculas() {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM REGISTRO", null);


        List<Cineverse> pelismatines = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do
                pelismatines.add(new Cineverse(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            while (cursor.moveToNext());


        }
        return pelismatines;
    }


    //BUSCAR DATOS

    public void BuscraPelis(Cineverse pels, String codigo) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM REGISTRO WHERE CODIGO='" + codigo + "'", null);

        if (cursor.moveToFirst()) {
            do {
                pels.setPelicula(cursor.getString(1));
                pels.setPais(cursor.getString(2));
                pels.setDuracion(cursor.getString(3));
                pels.setFecha(cursor.getString(4));
                pels.setGenero(cursor.getString(5));
                pels.setDirector(cursor.getString(6));
            } while (cursor.moveToNext());


        }
    }


    //EDITAR PELICULAS

    public void EditarPeliculas(String codigo, String pelicula, String pais, String duracion, String fecha, String genero, String director) {
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null) {
            bd.execSQL("UPDATE REGISTRO SET '"+pelicula+"','"+pais+"','"+duracion+"', '"+fecha+"','"+genero+"','"+director+"',WHERE '"+codigo+"'");
            bd.close();
        }

    }
    //ELIMINAR

    public void ELIMINAR(String codigo) {
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null) {
            bd.execSQL("DELETE FROM REGISTRO WHERE CODIGO='" + codigo + "'");
            bd.close();
        }

    }

}




