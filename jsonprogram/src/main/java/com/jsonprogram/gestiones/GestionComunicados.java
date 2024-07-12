package com.jsonprogram.gestiones;

public class GestionComunicados extends Funcionalidad {

    public GestionComunicados(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println(enunciado + "@" + codigo);
    }

}
