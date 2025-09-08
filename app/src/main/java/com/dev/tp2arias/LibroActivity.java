package com.dev.tp2arias;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dev.tp2arias.databinding.ActivityLibroBinding;
import com.dev.tp2arias.modelo.Libro;

public class LibroActivity extends AppCompatActivity {

    // esta va a ser la activity que va a recibir la busqueda de la main

    // instanciamos todo igual a la anterior pero referenciando este doc
    private ActivityLibroBinding binding;

    private LibroActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        vm = new LibroActivityViewModel(getApplication());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LibroActivityViewModel.class);

        vm.getMutableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro l) {
                binding.tvNombreLibro.setText(l.getNombre());
                binding.tvDatosPrincipales.setText(l.getAutor() + "\n" + l.getCantPaginas() + "\n"
                        + l.getAnio());
                binding.tvCategoria1.setText(l.getCategoriaUno());
                binding.tvCategoria2.setText(l.getCategoriaDos());
                binding.tvDescripcion.setText(l.getDescripcion());
                binding.imgLibro.setImageResource(l.getPortada());
            }
        });
        // psar el itent para que labure el view model
        vm.recuperarLibroEnviado(getIntent());





    }
}