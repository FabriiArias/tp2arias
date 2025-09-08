package com.dev.tp2arias;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.dev.tp2arias.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // view moodel main
    private MainActivityViewModel vm;

    // binding
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    // instaciar el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // instaciar el view model
        vm = new MainActivityViewModel(getApplication());
        // usamos el binding.get root en vez dde el R.layout.activity_main
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // palabra que busca
                String tituloBuscado = binding.etName.getText().toString();
                // buscar libro
                vm.buscarLibro(tituloBuscado);
            }
        });



    }
}