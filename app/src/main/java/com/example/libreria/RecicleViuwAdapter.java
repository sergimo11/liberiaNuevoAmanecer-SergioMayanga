package com.example.libreria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecicleViuwAdapter extends RecyclerView.Adapter<RecicleViuwAdapter.VieHolder>{

    public static class VieHolder extends RecyclerView.ViewHolder{

    private TextView  codigo,pelicula,pais,duracion,fecha,genero,director;


    public VieHolder( View itemView) {
        super(itemView);

        codigo = itemView.findViewById(R.id.text11);
        pelicula = itemView.findViewById(R.id.text22);
        pais= itemView.findViewById(R.id.text33);
        duracion = itemView.findViewById(R.id.text44);
        fecha = itemView.findViewById(R.id.text55);
        genero = itemView.findViewById(R.id.text66);
        director = itemView.findViewById(R.id.text77);




    }
}


public List<Cineverse>cineversesLista;

    public RecicleViuwAdapter(List<Cineverse> cineversesLista) {
        this.cineversesLista = cineversesLista;
    }

    @Override
    public VieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema,parent,false);
       VieHolder vieHolder=new VieHolder(view);
        return vieHolder;
    }

    @Override
    public void onBindViewHolder( VieHolder holder, int position) {
        holder.codigo.setText(cineversesLista.get(position).getCodigo());
        holder.pelicula.setText(cineversesLista.get(position).getPelicula());
        holder.pais.setText(cineversesLista.get(position).getPais());
        holder.duracion.setText(cineversesLista.get(position).getDuracion());
        holder.fecha.setText(cineversesLista.get(position).getFecha());
        holder.genero.setText(cineversesLista.get(position).getGenero());
        holder.director.setText(cineversesLista.get(position).getDirector());

    }

    @Override
    public int getItemCount() {
        return cineversesLista.size();
    }
}
