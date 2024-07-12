package com.jsonprogram.gestiones;

import com.jsonprogram.Controller;

public class GestionNoticias extends Funcionalidad {

    public GestionNoticias(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println(enunciado + "@" + codigo);
    }

}
