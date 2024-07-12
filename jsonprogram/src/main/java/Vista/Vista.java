package Vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jsonprogram.Controller;
import com.jsonprogram.Persona;
import com.jsonprogram.gestiones.Funcionalidad;

public class Vista {

    private  Persona persona;

    public Vista(Persona persona) {
        this.persona = persona;
    }

    public void mostrarVista() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jNode = objectMapper.readTree(new File("myJson.json"));
        java.util.Iterator<Map.Entry<String, JsonNode>> fields = jNode.fields();
        List<Funcionalidad> lstFuncionesPersona = new ArrayList<>();

        List<String> lstCodigosFuncionesPersona = new ArrayList<>();

        ArrayNode listaPersona = null;
        String msj = "";



        while ((fields.hasNext())) {
            Map.Entry<String, JsonNode> entry = fields.next();
            if (persona.rol.equals(entry.getKey()) ) {
                listaPersona = (ArrayNode) entry.getValue();
            }
        }

        if (listaPersona == null) {
            msj = "No hay menú disponible para este rol";
        } else {
            for (JsonNode element : listaPersona) {
                lstCodigosFuncionesPersona.add(element.toString());
            }
        }

        

        //System.out.println(lstCodigosFuncionesPersona);

        //lstCodigosFuncionesPersona.forEach((Funcionalidad funcion );
       
        for (Funcionalidad funcion : Controller.getController().lstFuncionalidades) {
            //System.out.println(funcion.codigo.getClass());
            //System.out.println(lstCodigosFuncionesPersona.contains(funcion.codigo));
            if (lstCodigosFuncionesPersona.contains('"' + funcion.codigo + '"')) {
                //System.out.println(funcion.codigo);
                lstFuncionesPersona.add(funcion);
            }

            /*for (String cod : lstCodigosFuncionesPersona) {
                System.out.println(cod.substring(1, cod.length()-1));
                System.out.println(funcion.codigo);
                //System.out.println(cod.getClass());
                if (cod.equals(funcion.codigo)) {
                    System.out.println("Yupiiiiii!");
                }
            }*/
        }

        if (lstFuncionesPersona.size() == 0) {
            System.out.println(msj);
        } else {
            for (Funcionalidad funcionVista : lstFuncionesPersona) {
                int opcion = lstFuncionesPersona.indexOf(funcionVista)  + 1;
                System.out.println(opcion + ". " + funcionVista.enunciado + "\n");
            }
        }

        int opcion = scanner.nextInt() -1 ;
        lstFuncionesPersona.get(opcion).ejecutar();
        scanner.next();
        

        //lstFuncionesPersona.get(0).ejecutar();

    }

}
