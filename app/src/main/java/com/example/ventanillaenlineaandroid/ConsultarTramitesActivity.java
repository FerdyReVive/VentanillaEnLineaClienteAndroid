package com.example.ventanillaenlineaandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ventanillaenlineaandroid.databinding.EstudianteConsultarTramitesBinding;

import java.util.ArrayList;

public class ConsultarTramitesActivity extends AppCompatActivity {
    EstudianteConsultarTramitesBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EstudianteConsultarTramitesBinding.inflate(getLayoutInflater());

        binding.tramiteRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Tramite> eqList = new ArrayList<>();
        eqList.add(new Tramite(1,"16/01/20225",2,1,1,new Usuario(
                2,
                "María López",
                "clave456",
                "maria@example.com",
                "pass456",
                2,
                1,
                1
        )));
        eqList.add(new Tramite(2,"17/01/2025",1,2,1,new Usuario( // <-- Instancia de Usuario
                1,
                "Karen Lopez",
                "clave123",
                "pablo@example.com",
                "pass123",
                2,
                1,
                1
        )));
        eqList.add(new Tramite(3,"15/01/2025",3,3,1,new Usuario( // <-- Instancia de Usuario
                1,
                "Juan Pérez",
                "clave123",
                "juan@example.com",
                "pass123",
                2,
                1,
                1
        )));
        eqList.add(new Tramite(4,"18/01/2025",1,4,2,new Usuario( // <-- Instancia de Usuario
                1,
                "Jose Hernandez",
                "clave123",
                "jose@example.com",
                "pass123",
                2,
                1,
                1
        )));
        eqList.add(new Tramite(5,"19/01/2025",2,5,0,new Usuario( // <-- Instancia de Usuario
                1,
                "Carlos Mendoza",
                "clave123",
                "juan@example.com",
                "pass123",
                2,
                1,
                1
        )));

        setContentView(binding.getRoot());

        TramiteAdapter adapter = new TramiteAdapter();
        binding.tramiteRecycler.setAdapter(adapter);
        adapter.submitList(eqList);
    }
}