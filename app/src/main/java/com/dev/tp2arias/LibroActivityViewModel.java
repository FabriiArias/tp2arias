package com.dev.tp2arias;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.tp2arias.modelo.Libro;

public class LibroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mutableLibro;
    public LibroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getMutableLibro (){
        if(mutableLibro == null){
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }

    // recuperar el libro, para que la activity se entere que recuper el lubro, lo guardo
    // en un mutable, cuando el mutable reciba el libro, la activity lo detecta y lo muestra

    public void recuperarLibroEnviado(Intent intent){
        Libro libroEnviado = (Libro) intent.getSerializableExtra("Libro encontrado", Libro.class);
        mutableLibro.setValue(libroEnviado);
    }

}
