package com.example.kevinteasdaledube.exercicexml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

/**
 * La classe nécessite un générique.
 * Dans ce cas-ci, nous lui passons MainAdapter.ViewHolder,
 */
    private List<Book> dataSet;


    // Fournit une référence aux vues pour chaque élément de données
    // les éléments de données complexes peuvent nécessiter plus d'une vue par élément, et
    // vous donne accès à toutes les vues d'un élément de données dans un titulaire de vue
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* textView qui devra contenir la donnée "nom" */
        private final TextView author;
        private final TextView title;
        private final TextView summary;
        private final TextView isbn;
        private final TextView localization;



        public ViewHolder(View v) {
            super(v);
            author = v.findViewById(R.id.textViewAuthor);
            title = v.findViewById(R.id.textViewTitle);
            summary = v.findViewById(R.id.textViewSummary);
            isbn = v.findViewById(R.id.textViewIsbn);
            localization = v.findViewById(R.id.textViewLocalization);

        }
    }

    // Constructeur
    public Adapter(List myDataset) {
        dataSet = myDataset;
    }

    // Génère ne nouvelles vues (invoqué par le layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        // Instancie un fichier XML de Layout dans les objets View correspondants.

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_layout, parent, false);
        return new ViewHolder(view);
    }

    // Remplace le contenu d'une vue (invoqué par le layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Remplace le texte de la vue
        holder.author.setText(dataSet.get(position).getAuthor());
        holder.title.setText(dataSet.get(position).getTitle());
        holder.summary.setText(dataSet.get(position).getSummary());
        holder.isbn.setText(dataSet.get(position).getIsbn());
        holder.localization.setText(dataSet.get(position).getLocalization());

    }

    // Doit retourner la largeur(size) du dataset (invoqué par le layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}