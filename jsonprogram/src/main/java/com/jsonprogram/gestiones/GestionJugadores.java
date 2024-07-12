package com.jsonprogram.gestiones;

public class GestionJugadores extends Funcionalidad {

    public GestionJugadores(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println(enunciado + "@" + codigo);
    }

}
