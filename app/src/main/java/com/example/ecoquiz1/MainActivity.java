package com.example.ecoquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable, ConvertersPro{

    //elementos view
    private Button continuar;
    private TextView usersList;
    private TextView id;
    private SharedPreferences knowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //>>>>>>>>>>>>
        continuar = findViewById(R.id.continuar);
        usersList= findViewById(R.id.usersList);
        id = findViewById(R.id.id);
        id.setVisibility(View.INVISIBLE);


        continuar.setOnClickListener(
                (view)->{
                    Intent i = new Intent(this, Registro.class);
                    startActivity(i);
                }
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
        //-----------------------
        String userArrived  = getSharedPreferences("userGet",MODE_PRIVATE).getString("userInfo","nada");
        int currentCuenta = getSharedPreferences("userGet",MODE_PRIVATE).getInt("userCuenta",0);
        usersList.append(userArrived+"-"+currentCuenta +",");
        ArrayList<Usuario>example = toArrayPro(usersList.getText().toString());
        knowId =  getSharedPreferences("userIds",MODE_PRIVATE);
        for(int i = 0; i< example.size(); i++){
            knowId.edit().putString("ids",  example.get(i).getId()).apply();
            id.append("-"+example.get(i).getId());
            knowId.edit().putString("ids",id.getText().toString()).apply();
            usersList.setText(example.get(i).getNombre()+" :"+example.get(i).getAcumulado()+"\n");
        }


    }
}