package com.jsonprogram;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jsonprogram.gestiones.GestionEquipos;

import Vista.Vista;


public class Main {
    public static void main(String[] args) throws Exception{
        /*ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();

        jsonNode.put("Daniel", "[\"Uno\", \"Dos\"]");
        jsonNode.put("Camilo", "[\"Tres\", \"Cinco\"]");
        jsonNode.put("Chris", "[\"Dos\", \"Cuatro\"]");
        jsonNode.put("Santiago", "[\"Uno\", \"Tres\"]");
        jsonNode.put("Juan", "[\"Uno\", \"Cinco\"]");*/

        //objectMapper.writeValue(new File("myJson.json"), jsonNode);

        //JsonNode jNode = objectMapper.readTree(new File("myJson.json"));

        

        //Persona myPerson = new Persona("Daniel", "Tecnico");
        //ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jNode.toString()).get(myPerson.rol);

        //java.util.Iterator<Map.Entry<String, JsonNode>> fields = jNode.fields();
        //System.out.println(fields.getClass());

        /*for (Map.Entry<String, JsonNode> element : fields) {
            
        }*/

        /*ArrayNode listaPersona = null;

        while ((fields.hasNext())) {
            Map.Entry<String, JsonNode> entry = fields.next();
            if (myPerson.nombre.equals(entry.getKey()) ) {
                listaPersona = (ArrayNode) entry.getValue();
            }
        }

        for (JsonNode element : listaPersona) {
            myPerson.arrayInner.add(element.toString());
        }*/

        //System.out.println(myPerson.arrayInner);
        String mensaje = "SoyDaniel";
        //String mensaje_2 = "SoyCamilo";
        byte [] msjByte = mensaje.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest =  MessageDigest.getInstance("SHA-256");

        
        //digest.update(msjByte, 0, 0);

        byte [] hash = digest.digest(msjByte);
        

        StringBuilder hexString = new StringBuilder();
        

        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }

        

        System.out.println("Encriptada_1: --> " + hexString);
        //System.out.println("Encriptada_2: --> " + hexString_2.toString().equals(hexString.toString()));

        Persona myPersona = new Persona("Daniel", "Admin");

        Scanner scanner = new Scanner(System.in);
        Vista miVista = new Vista(myPersona);
        miVista.mostrarVista();
        System.out.println("Ingrese su contraseña: ");
        System.out.println("--> ");
        String mensaje_2= scanner.nextLine();

        byte [] msjByte_2 = mensaje_2.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest_2 =  MessageDigest.getInstance("SHA-256");
        byte [] hash_2 = digest_2.digest(msjByte_2);
        StringBuilder hexString_2 = new StringBuilder();
        
        for (int j = 0; j < hash_2.length; j++) {
            final String hex_2 = Integer.toHexString(0xff & hash_2[j]);
            if(hex_2.length() == 1) 
              hexString_2.append('0');
            hexString_2.append(hex_2);
        }

        if (hexString_2.toString().equals(hexString.toString())) {
            System.out.println("\nBIENVENIDO");
        } else {
            System.out.println("\nCONTRASEÑA INCORRECTA");
        }
        

    }
}