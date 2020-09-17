package com.example.ecoquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Registro extends AppCompatActivity implements ConvertersPro {
    private Button continuar;
    private EditText nombre;
    private EditText identificacion;
    private TextView txt;
    private String[]finalIds;
    private TextView txt1;
    SharedPreferences thisUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.nombre);
        identificacion = findViewById(R.id.identificacion);
        continuar = findViewById(R.id.continuar);
        txt = findViewById(R.id.txt);
        txt.setVisibility(View.INVISIBLE);
        txt1 = findViewById(R.id.txt1);
        thisUser = getSharedPreferences("userGet",MODE_PRIVATE);


        continuar.setOnClickListener(
                (view)->{
                    Intent i = new Intent(this, nexoEpi.class);
                    String currentData = nombre.getText().toString()+"-"+identificacion.getText().toString();
                    thisUser.edit().putString("userInfo",currentData).apply();
                    String ids = getSharedPreferences("userIds",MODE_PRIVATE).getString("ids","nada");
                    finalIds = ids.split("-");
                    for (int o = 0; o < finalIds.length; o++){
                    }
                   if (!useSet(finalIds,identificacion.getText().toString())){
                       startActivity(i);
                       finish();
                    }else{
                       //id ya usado
                       txt1.setText("Intenta con un ID diferente a"+identificacion.getText().toString());
                   }
                }
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    //valido si el id ya se ha usado
    public static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }
}