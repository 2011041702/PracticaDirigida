package com.example.practicadirigida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private EditText txt_texto;
    private EditText txt_numero;
    private Button btn_calcular;


    String texto;
    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_numero = (EditText) findViewById(R.id.txtnumero);
        txt_texto = (EditText)findViewById(R.id.txttexto);
        btn_calcular = (Button)findViewById(R.id.btnCalcular);


        //num = Integer.parseInt(txt_numero.getText().toString());

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (txt_texto.length()==0){
                    Toast.makeText(MainActivity.this, "Ingrese un texto", Toast.LENGTH_SHORT).show();
                }
                else if (txt_numero.length()==0){
                    Toast.makeText(MainActivity.this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show();
                }
                else{
                    texto = txt_texto.getText().toString();
                    num = Integer.parseInt(txt_numero.getText().toString());

                    StringTokenizer st = new StringTokenizer(texto);
                    String[] words = texto.split(" ");
                    int total = words.length;
                    if (num<0) num = 0;
                    if (num>total) num = total;

                    String out ="";
                    int i;
                    for (i=0;i<num-1;++i) {
                        out +=  (i==0)? words[i]: " " + words[i];
                    }
                    String endWord = words[i];
                    String endChar = endWord.substring(endWord.length() - 1);
                    if (endChar.equals(".")) endChar = "";
                    if (endChar.equals(",")) endChar = "";
                    if (endChar.equals(";")) endChar = "";
                    if (endChar.equals(":")) endChar = "";
                    if (endChar.equals("&")) endChar = "";
                    if ((!endChar.equals("?")) && (!endChar.equals("!"))) endChar += ".";
                    endWord = endWord.substring(0,endWord.length() - 1)  + endChar;
                    endWord = endWord.trim();
                    String spaces = (endWord.length()>1)? " ":"";
                    endWord =  spaces + endWord;
                    out += endWord;
                    int exp = st.countTokens();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("NumeroPalabras", exp);
                    intent.putExtra("PalabrasEnviadas",out);
                    startActivity(intent);
                }
            }
        });




    }



}
