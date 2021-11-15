package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1_Aux extends AppCompatActivity {
    private Button btnAceptar, btnRechazar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_aux);
        TextView txt = (TextView) findViewById(R.id.textViewCondiciones);
        Bundle extras = getIntent().getExtras();
        txt.setText("Hola " + ((String) extras.get("name")).toUpperCase() + " " + ((String) extras.get("surname")).toUpperCase() + " ¿Aceptas las condiciones?");
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);



        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1_Aux.this, Activity1.class);
                intent.putExtra("name", (String) extras.get("name"));
                intent.putExtra("surname", (String) extras.get("surname"));
                intent.putExtra("resultado", "aceptado");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnRechazar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1_Aux.this, Activity1.class);
                intent.putExtra("name", (String) extras.get("name"));
                intent.putExtra("surname", (String) extras.get("surname"));
                intent.putExtra("resultado", "reachazado");
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}