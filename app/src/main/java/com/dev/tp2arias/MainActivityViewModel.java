package com.dev.tp2arias;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.tp2arias.modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mensajeMutable;

    private List<Libro> listaLibro;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensajeMutable() {
        if (mensajeMutable == null){
            mensajeMutable = new MutableLiveData<>();
        }
        return mensajeMutable;
    }

    public void cargarListaLibros() {
        listaLibro = new ArrayList<>();
        listaLibro.add(new Libro(
                R.drawable.soledad,
                "uno",
                "La saga de la familia Buendía en el mítico pueblo de Macondo.",
                "Realismo mágico",
                "Clásico",
                "Gabriel García Márquez",
                "1967",
                "471"
        ));

        listaLibro.add(new Libro(
                R.drawable.viento,
                "dos",
                "La historia de un joven llamado Kvothe que se convierte en leyenda.",
                "Fantasía",
                "Aventura",
                "Patrick Rothfuss",
                "2007",
                "662"
        ));

        listaLibro.add(new Libro(
                R.drawable.sapiens,
                "tres",
                "Un recorrido por la historia de la humanidad desde sus orígenes.",
                "Historia",
                "Ensayo",
                "Yuval Noah Harari",
                "2011",
                "512"
        ));
    }

    // CAMINO UNO
    // 1 - que quiero devolver? ---> un libro
    // 2 - a quien quiero deevolverlo? --> a una activity
    // 3 - entonces a la segunda act, le paso el libro con el Itent, como no hace falta que la segunda act
    // este pendiente de si el libro esta o no, no hace falta que haga el mutable del libro
    // 4- creamos un metodo que busque el libro y llame a la segunda activity

    public void buscarLibro(String nombreBusca){
        cargarListaLibros();
        for (Libro libroAux : listaLibro){
            if ( libroAux.getNombre().equalsIgnoreCase(nombreBusca)){
                // se crea el intent solo si se encuentra el libro
                Intent intent = new Intent(getApplication(), LibroActivity.class);
                // se carga con el putExtra
                intent.putExtra("Libro encontrado", libroAux);
                // flag para intent cuando no eesta en una activity
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                // el contexto lo tomamos del constructor "aplication"
                getApplication().startActivity(intent);

            }
        }
    }

}
