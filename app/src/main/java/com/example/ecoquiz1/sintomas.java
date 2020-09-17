package com.example.ecoquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class sintomas extends AppCompatActivity implements ConvertersPro{
        private Button continuar;
    private CheckBox b1,b2,b3,b4,b5,b6,b7;
    private int cuenta;
    private int cuentaThis;
    private SharedPreferences thisUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        thisUser = getSharedPreferences("userGet",MODE_PRIVATE);

        b1 = (CheckBox) findViewById(R.id.b1);
        b2 = (CheckBox) findViewById(R.id.b2);
        b3 = (CheckBox) findViewById(R.id.b3);
        b4 = (CheckBox) findViewById(R.id.b4);
        b5 = (CheckBox) findViewById(R.id.b5);
        b6 = (CheckBox) findViewById(R.id.b6);
        b7 = (CheckBox) findViewById(R.id.b7);
        continuar = findViewById(R.id.continuar);
        cuentaThis= getIntent().getExtras().getInt("cuentaCurrent");
        continuar.setOnClickListener(
                (view)->{
                    //verifico si al menos una opcion esta seleccionada
                    if(b1.isChecked()||b2.isChecked()||b3.isChecked()||b4.isChecked()||b5.isChecked()||b6.isChecked()||b7.isChecked()){
                        valido();
                        thisUser.edit().putInt("userCuenta",cuenta).apply();
                        Log.e("ojojojojojojojo", ""+cuenta);
                        finish();
                    }

                }
        );
    }
    public void valido(){
//en este metodo valido el estado de cada checkbox
        if(b1.isChecked()){

            cuenta += 3;
        }
        if(b2.isChecked()){

            cuenta += 3;
        }
        if(b3.isChecked()){

            cuenta += 3;
        }
        if(b4.isChecked()){

            cuenta += 3;
        }
        if(b5.isChecked()){

            cuenta += 3;
        }
        if(b6.isChecked()){

            cuenta += 3;
        }
        //si selecciono ninguna de las anteriores, desselecciono todas las opciones anteriores
        if(b7.isChecked()){
            b1.setChecked(false);
            b2.setChecked(false);
            b3.setChecked(false);
            b4.setChecked(false);
            b5.setChecked(false);
            b6.setChecked(false);
            cuenta =0;
        }
        //aqui sumo el valor de la pantalla anterior con el de esta, generando el total final
        cuenta+=cuentaThis;
    }
}