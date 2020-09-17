package com.example.ecoquiz1;

import java.util.ArrayList;
import java.util.Arrays;

public interface ConvertersPro {
    default String convertToString(ArrayList<String> list) {

        StringBuilder sb = new StringBuilder();
        String delim = "";
        for (String s : list)
        {
            sb.append(delim);
            sb.append(s);;
            delim = ",";
        }
        return sb.toString();
    }
    default ArrayList<String> convertToArray(String string) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(string.split(",")));
        return list;
    }
    default ArrayList<String> toStringPro(ArrayList<Usuario> usuarios){
        ArrayList<String>converter = new ArrayList<String>();
        for (int i = 0; i< usuarios.size();i++){
            Usuario u = usuarios.get(i);
            converter.add(u.getNombre()+"-"+u.getId()+"-"+u.getAcumulado());
        }
        return converter;
    }
    default ArrayList<Usuario> toArrayPro(String string) {
        String [] efe = string.split(",");
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        for (int i = 0; i < efe.length; i++){
            String[] create= efe[i].split("-");
            usuarios.add(new Usuario(create[0],create[1],Integer.parseInt(create[2])));
        }
        return usuarios;
    }



    default Usuario toUserPro(String string) {
        String [] efe = string.split("-");
        Usuario u;
        u = new Usuario(efe[0],efe[1],Integer.parseInt(efe[2]));
        return u;
    }

}
