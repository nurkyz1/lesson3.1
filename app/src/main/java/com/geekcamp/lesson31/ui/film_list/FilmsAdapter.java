package com.geekcamp.lesson31.ui.film_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekcamp.lesson31.data.models.Film;
import com.geekcamp.lesson31.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<Film> films= new ArrayList<>();
    ItemFilmBinding binding;
    OnFilmClickListener listener;

    public void setListener(OnFilmClickListener listener) {
        this.listener = listener;
    }
    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent,false);

        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
    holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public  class FilmsViewHolder extends  RecyclerView.ViewHolder{

        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void onBind(Film film) {
            binding.filmName.setText(film.getTitle());
            binding.filmDirector.setText(film.getDirector());

            itemView.setOnClickListener(v -> {
            listener.onClick(film.getId());
            });
        }
    }
}
