package com.example.libreria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class libroTools extends SQLiteOpenHelper {
    private static final String NOm_BD = "Nuevo Amanecer.db";
    private static final int VER_BD = 1;
    private static final String Tabla_BD = "CREATE TABLE REGISTRO(CODIGO TEXT PRIMARY KEY, LIBRO TEXT ,PAIS  TEXT, PAGINAS  TEXT , GENERO  TEXT ,AUTOR TEXT, EDITORIAL TEXT)";

    public libroTools(Context context) {

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

    public void REGISTRAR(String codigo, String libro , String pais, String paginas, String genero, String autor, String editorial) {
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null) {
            bd.execSQL("INSERT INTO REGISTRO  VALUES('" + codigo + "',  '" + libro + "','" + pais + "','" + paginas + "','" + genero + "','" + autor + "','" + editorial+ "') ");
            bd.close();
        }

    }

    public List<libroverse> Mostrarlibro() {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM REGISTRO", null);


        List<libroverse> libromatines = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do
                libromatines.add(new libroverse(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            while (cursor.moveToNext());


        }
        return libromatines;
    }


    //BUSCAR DATOS

    public void Buscralibro(libroverse pels, String codigo) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM REGISTRO WHERE CODIGO='" + codigo + "'", null);

        if (cursor.moveToFirst()) {
            do {
                pels.setLibro(cursor.getString(1));
                pels.setPais(cursor.getString(2));
                pels.setPaginas(cursor.getString(3));
                pels.setGenero(cursor.getString(4));
                pels.setDirector(cursor.getString(5));
                pels.setEditorial(cursor.getString(6));
            } while (cursor.moveToNext());


        }
    }


    //EDITAR PELICULAS

    public void Editarlibro(String codigo, String libro, String pais, String paginas, String genero, String director, String editorial) {
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null) {
            bd.execSQL("UPDATE REGISTRO SET '"+libro+"','"+pais+"','"+paginas+"', '"+genero+"','"+director+"','"+editorial+"',WHERE '"+codigo+"'");
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




