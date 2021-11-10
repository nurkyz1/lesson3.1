package com.geekcamp.lesson31.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekcamp.lesson31.R;
import com.geekcamp.lesson31.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}