package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvResultado.setText(s);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.radioEuroDolar.isChecked()){
                mv.Conversion("",binding.etEuros.getText().toString());}
                if(binding.radioDolarEuro.isChecked()){
                    mv.Conversion(binding.etDolar.getText().toString(),"");
                }
            }
        });
        binding.radioDolarEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEuros.setEnabled(false);
                binding.etDolar.setEnabled(true);
                binding.etEuros.setText("");
            }
        });
        binding.radioEuroDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEuros.setEnabled(true);
                binding.etDolar.setEnabled(false);
                binding.etDolar.setText("");
            }
        });
    }
}