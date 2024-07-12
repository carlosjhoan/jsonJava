package com.jsonprogram.gestiones;

public class GestionEntrenamientos extends Funcionalidad{

    public GestionEntrenamientos(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println(enunciado + "@" + codigo);
    }

}
