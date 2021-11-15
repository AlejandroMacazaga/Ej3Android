package com.example.ejercicio3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private EditText txtNum1, txtNum2, txtRespuesta;
    private TextView txtCorrectas, txtIncorrectas;
    private Button btnComprobar;
    private int correctas, incorrectas;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtNum1 = (EditText) findViewById(R.id.editTextNum1);
        txtNum2 = (EditText) findViewById(R.id.editTextNum2);
        txtRespuesta = (EditText) findViewById(R.id.editTextRespuesta);
        num1 = (int) (Math.random() * 100);
         num2 = (int) (Math.random() * 100);

        txtNum1.setText(num1 + "");
        txtNum2.setText(num2 + "");
        txtCorrectas = (TextView) findViewById(R.id.textViewCorrectas);
        txtIncorrectas = (TextView) findViewById(R.id.textViewIncorrectas);
        correctas = incorrectas = 0;

        txtCorrectas.setText(getText(R.string.txtCorrectas) + "" + correctas);
        txtIncorrectas.setText(getText(R.string.txtIncorrectas) + "" + incorrectas);

        btnComprobar = (Button) findViewById(R.id.btnComprobar);

        btnComprobar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Activity2.this, Activity2_aux.class);

                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    intent.putExtra("result", Integer.parseInt(txtRespuesta.getText().toString()));
                    startActivityForResult(intent, 1);
                } catch(NumberFormatException ex) {

                }
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 1
        if(requestCode==1)
        {
            boolean result = data.getExtras().getBoolean("success");
            if(result) {
                correctas++;
                txtCorrectas.setText(getText(R.string.txtCorrectas) + "" + correctas);
                txtIncorrectas.setText(getText(R.string.txtIncorrectas) + "" + incorrectas);
                num1 = (int) (Math.random() * 100);
                num2 = (int) (Math.random() * 100);

                txtNum1.setText(num1 + "");
                txtNum2.setText(num2 + "");
                txtRespuesta.setText("");
            }
            else {
                incorrectas++;
                txtCorrectas.setText(getText(R.string.txtCorrectas) + "" + correctas);
                txtIncorrectas.setText(getText(R.string.txtIncorrectas) + "" + incorrectas);
                num1 = (int) (Math.random() * 100);
                num2 = (int) (Math.random() * 100);

                txtNum1.setText(num1 + "");
                txtNum2.setText(num2 + "");
                txtRespuesta.setText("");
            }
        }
    }
}