package com.geekcamp.lesson31.ui.film_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekcamp.lesson31.App;
import com.geekcamp.lesson31.R;
import com.geekcamp.lesson31.data.models.Film;
import com.geekcamp.lesson31.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment implements  OnFilmClickListener{

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter= new FilmsAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFilmsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.setListener(this);
        binding.recycler.setAdapter(adapter);


        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()&& response.body()!= null){
                    adapter.setFilms(response.body());
                }else {
                    Log.e("TAG","onFailure: "+ response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("TAG","onFailure: "+ t.getLocalizedMessage());
            }
        });

    }
    @Override
    public void onClick(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("key",id);
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.filmDetailFragment,bundle);
    }
}