package com.example.ecoquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class nexoEpi extends AppCompatActivity implements ConvertersPro{
    private CheckBox a1,a2,a3,a4,a5;

    private Button continuar;
    private int cuenta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epi);

        a1 = (CheckBox) findViewById(R.id.a1);
        a2 = (CheckBox) findViewById(R.id.a2);
        a3 = (CheckBox) findViewById(R.id.a3);
        a4 = (CheckBox) findViewById(R.id.a4);
        a5 = (CheckBox) findViewById(R.id.a5);
        continuar = findViewById(R.id.continuar);
        continuar.setOnClickListener(
                (view)->{
                    //verifico si se ha seleccionado al menos una opcion
                    if(a1.isChecked()||a2.isChecked()||a3.isChecked()||a4.isChecked()||a5.isChecked()) {
                        Intent i = new Intent(this, sintomas.class);
                        valido();
                        //envio el resultado sumado de esta pantalla a la siguiente donde lo sumare y agregare al usuario
                        i.putExtra("cuentaCurrent",cuenta);
                        startActivity(i);

                        finish();
                    }
                }
        );
    }
    public void valido(){
        //en este metodo valido el estado de cada checkbox
        if(a1.isChecked()){

            cuenta += 4;
        }
        if(a2.isChecked()){

            cuenta += 4;
        }
        if(a3.isChecked()){

            cuenta += 4;
        }
        if(a4.isChecked()){

            cuenta += 4;
        }
        if(a5.isChecked()){
            a1.setChecked(false);
            a2.setChecked(false);
            a3.setChecked(false);
            a4.setChecked(false);

            cuenta =0;
        }
    }
}