package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Activity3 extends AppCompatActivity {
    private EditText editTextPersona, editTextApellidos;
    private RadioButton radioButtonHombre, radioButtonMujer;
    private CheckBox checkBoxMusica, checkBoxLectura, checkBoxDeportes, checkBoxViajar;
    private Button buttonEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        editTextPersona = (EditText) findViewById(R.id.editTextPersona);
        editTextApellidos = (EditText) findViewById(R.id.editTextApellidos);
        radioButtonHombre = (RadioButton) findViewById(R.id.radioButtonHombre);
        radioButtonMujer = (RadioButton) findViewById(R.id.radioButtonMujer);
        checkBoxMusica = (CheckBox) findViewById(R.id.checkBoxMusica);
        checkBoxLectura = (CheckBox) findViewById(R.id.checkBoxLectura);
        checkBoxViajar = (CheckBox) findViewById(R.id.checkBoxViajar);
        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok = true;
                Intent intent = new Intent(Activity3.this, Activity3_aux.class);
                if(editTextPersona.getText().toString().trim() == "") {
                    new AlertDialog.Builder(Activity3.this)
                            .setTitle("Falta texto nombre")
                            .setMessage("Por favor introduce el nombre");
                    ok = false;
                } else {
                    intent.putExtra("nombre",editTextPersona.getText().toString().trim());
                }
                if(editTextApellidos.getText().toString().trim() == "") {
                    new AlertDialog.Builder(Activity3.this)
                            .setTitle("Falta texto apellidos")
                            .setMessage("Por favor introduce los apellidos");
                    ok = false;
                } else {
                    intent.putExtra("nombre",editTextPersona.getText().toString().trim());
                }
                if(radioButtonHombre.isChecked() || radioButtonMujer.isChecked()) {
                    if(radioButtonHombre.isChecked()) {
                        intent.putExtra("sexo","hombre");
                    }
                    if(radioButtonMujer.isChecked()) {
                        intent.putExtra("sexo","mujer");
                    }
                }
                else {
                        new AlertDialog.Builder(Activity3.this)
                                .setTitle("Falta sexo")
                                .setMessage("Por favor selecciona el sexo");
                        ok = false;
                }
                String[] aficiones = new String[4];
                if(checkBoxDeportes.isChecked() ) {
                    aficiones[aficiones.length] = "deportes";
                }
                if(checkBoxMusica.isChecked() ) {
                    aficiones[aficiones.length] = "musica";
                }
                if(checkBoxLectura.isChecked() ) {
                    aficiones[aficiones.length] = "lectura";
                }
                if(checkBoxViajar.isChecked() ) {
                    aficiones[aficiones.length] = "viajar";
                }
                intent.putExtra("aficiones", aficiones);
                if(ok) {
                    startActivityForResult(intent, 1);
                }
            }
        });
    }
}