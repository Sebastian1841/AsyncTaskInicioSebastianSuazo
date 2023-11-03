package com.example.asynctaskinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        et3 = findViewById(R.id.txt_welcome);

        String nombreUsuario = getIntent().getStringExtra("Usuario");
        et3.setText("Bienvenido: " + nombreUsuario);

    }
}