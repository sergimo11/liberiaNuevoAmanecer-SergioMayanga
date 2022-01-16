package com.example.libreria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecicleViuwAdapter extends RecyclerView.Adapter<RecicleViuwAdapter.VieHolder>{

    public static class VieHolder extends RecyclerView.ViewHolder{

    private TextView  codigo,libro,pais,paginas,genero,director,editorial;


    public VieHolder( View itemView) {
        super(itemView);

        codigo = itemView.findViewById(R.id.text11);
        libro = itemView.findViewById(R.id.text22);
        pais= itemView.findViewById(R.id.text33);
        paginas = itemView.findViewById(R.id.text44);
        genero= itemView.findViewById(R.id.text55);
        director = itemView.findViewById(R.id.text66);
        editorial = itemView.findViewById(R.id.text77);




    }
}


public List<libroverse>cineversesLista;

    public RecicleViuwAdapter(List<libroverse> cineversesLista) {
        this.cineversesLista = cineversesLista;
    }

    @Override
    public VieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libros,parent,false);
       VieHolder vieHolder=new VieHolder(view);
        return vieHolder;
    }

    @Override
    public void onBindViewHolder( VieHolder holder, int position) {
        holder.codigo.setText(cineversesLista.get(position).getCodigo());
        holder.libro.setText(cineversesLista.get(position).getLibro());
        holder.pais.setText(cineversesLista.get(position).getPais());
        holder.paginas.setText(cineversesLista.get(position).getPaginas());
        holder.genero.setText(cineversesLista.get(position).getGenero());
        holder.director.setText(cineversesLista.get(position).getDirector());
        holder.editorial.setText(cineversesLista.get(position).getEditorial());

    }

    @Override
    public int getItemCount() {
        return cineversesLista.size();
    }
}
