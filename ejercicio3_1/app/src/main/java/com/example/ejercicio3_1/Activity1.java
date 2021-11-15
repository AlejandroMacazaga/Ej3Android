package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private EditText txtNombre, txtApellidos;
    private boolean condiciones;
    private Button btnVerificar, btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        txtNombre = (EditText) findViewById(R.id.editTextNombre);
        txtApellidos = (EditText) findViewById(R.id.editTextApellidos);
        condiciones = false;
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        btnVolver = (Button) findViewById(R.id.btnVolver);


        btnVerificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String name = txtNombre.getText().toString();
                String surname = txtApellidos.getText().toString();
                if(!name.equals("") && !surname.equals("")) {
                    Intent intent = new Intent(Activity1.this, Activity1_Aux.class);
                    intent.putExtra("name", name);
                    intent.putExtra("surname", surname);
                    startActivityForResult(intent, 1);
                }

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 1
        if(requestCode==1)
        {
            String message=data.getStringExtra("result");
            txtNombre.setText(data.getStringExtra("name"));
            txtApellidos.setText(data.getStringExtra("surname"));
            TextView condiciones = (TextView) findViewById(R.id.textView3);
            condiciones.setText(getText(R.string.aceptarCondiciones) + ": " + data.getStringExtra("resultado"));
        }
    }

}