package com.example.practicadirigida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView texto;
    private TextView cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        int ddd = b.getInt("NumeroPalabras");
        String palabras = b.getString("PalabrasEnviadas");

        texto = (TextView)findViewById(R.id.txtPalabras);
        cantidad = (TextView)findViewById(R.id.txtCantidad);


        texto.setText(palabras);
        cantidad.setText(String.valueOf(ddd));


    }
}
