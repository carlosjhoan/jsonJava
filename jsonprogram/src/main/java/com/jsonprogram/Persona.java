package com.jsonprogram;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    public String nombre;
    public String rol;
    public List<String> arrayInner;
    public Persona(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        this.arrayInner = new ArrayList<>();
    }


}
