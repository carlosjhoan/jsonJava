package com.jsonprogram.gestiones;

public class GestionEquipos extends Funcionalidad {

    public GestionEquipos(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println(enunciado + "@" + codigo);
    }

}
