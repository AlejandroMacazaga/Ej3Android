package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3_aux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_aux);
        TextView txt = findViewById(R.id.textViewAll);
        Bundle b = getIntent().getExtras();
        txt.setText(b.getString("nombre") + " " + b.getString("apellidos") + " es " + b.getString("sexo") + " tiene las aficiones " + b.getStringArray("aficiones").toString());
    }
}