package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2_aux extends AppCompatActivity {
    private TextView txtResultado;
    private Button btnVolver;
    private boolean success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_aux);

        txtResultado = (TextView) findViewById(R.id.textViewFlavourResultado);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        int num1 = extras.getInt("num1");
        int num2 = extras.getInt("num2");
        int result= extras.getInt("result");
        if(num1 + num2 == result) {
            txtResultado.setText("El resultado de la operacion es CORRECTA");
            success = true;
        }
        else {
            txtResultado.setText("El resultado de la operacion es INCORRECTA");
            success = false;
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2_aux.this, Activity2.class);

                intent.putExtra("success", success);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}