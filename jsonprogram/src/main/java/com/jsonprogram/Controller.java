package com.jsonprogram;

import java.util.ArrayList;
import java.util.List;

import com.jsonprogram.gestiones.Funcionalidad;
import com.jsonprogram.gestiones.GestionEntrenamientos;
import com.jsonprogram.gestiones.GestionEquipos;
import com.jsonprogram.gestiones.GestionJugadores;
import com.jsonprogram.gestiones.GestionNoticias;

public class Controller {
    public static List<Funcionalidad> lstFuncionalidades;

    private static Controller INSTANCE = new Controller();

    public Controller() {
        lstFuncionalidades = new ArrayList<>();
        Funcionalidad gestionEquipos = new GestionEquipos("Gestion Equipos", "geq");
        Funcionalidad gestionJugadores = new GestionJugadores("Gestion Jugadores", "gjug");
        Funcionalidad gestionEntrenamientos = new GestionEntrenamientos("Gestion Entrenamientos", "gent");
        Funcionalidad gestionComunicados = new GestionEquipos("Gestion Comunicados", "gcom");
        Funcionalidad gestionNoticias = new GestionNoticias("Gestion Noticias", "gnot");
        lstFuncionalidades.add(gestionEquipos);
        lstFuncionalidades.add(gestionJugadores);
        lstFuncionalidades.add(gestionEntrenamientos); 
        lstFuncionalidades.add(gestionComunicados);
        lstFuncionalidades.add(gestionNoticias);
    }

    public static Controller getController () {
        return INSTANCE;
    }
    
}
