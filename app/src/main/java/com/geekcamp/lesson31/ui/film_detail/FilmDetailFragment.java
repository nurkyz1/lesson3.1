package com.geekcamp.lesson31.ui.film_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geekcamp.lesson31.App;
import com.geekcamp.lesson31.R;
import com.geekcamp.lesson31.data.models.Film;
import com.geekcamp.lesson31.databinding.FragmentFilmDetailBinding;
import com.geekcamp.lesson31.ui.film_list.FilmsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmDetailFragment extends Fragment {

  private   FragmentFilmDetailBinding binding;
        private  String id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        id = getArguments().getString("key");
        if (id!=null) {
            App.api.getFilm(id).enqueue(new Callback<Film>() {
                @Override
                public void onResponse(Call<Film> call, Response<Film> response) {
                    if (response.isSuccessful() && response.body() != null) {
                    SetFilm(response.body());
                    }else {
                        Log.e("TAG","onFailure: "+response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<Film> call, Throwable t) {
                Log.e("TAG","onFailure: "+ t.getLocalizedMessage());
                }
            });
        }
    }
    private void  SetFilm(Film film){
        binding.filmName.setText(film.getTitle());
        binding.filmDescription.setText(film.getDescription());
        binding.filmOriginalTitle.setText(film.getOriginalTitle());
        binding.filmDirector.setText(film.getDirector());
        binding.filmReleaseDate.setText(film.getReleaseDate());
        binding.filmProducer.setText(film.getProducer());
        binding.filmRunningTime.setText(film.getRunningTime());
        Glide.with(this).load(film.getImage()).into(binding.filmImage);
       }
}