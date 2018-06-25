package com.uade.ejb.backoffice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.tools.ConsoleLogger;

public class Backoffice {
	private static final String URL_BACKOFFICE = "http://152.170.43.218:8080/BackofficeWebServices/rest";
	// private static final String URL_BACKOFFICE = "http://192.168.0.150:8080/BackofficeWebServices/rest";
    // private static final String URL_BACKOFFICE = "http://192.168.130.104:8080/IA_TPO_BO_G05_DWS/REST";

    public static String enviarSolicitudHotelera(EstablecimientoEntity establecimiento) {
    	String codEntidad = null;
        try {
        	SolicitudHoteleraRequest request = new SolicitudHoteleraRequest();
        	request.direccion = establecimiento.direccion;
        	request.nombre = establecimiento.nombre;
        	request.tipo = 1; // Solicitud OH
        	
            ResteasyClient client = new ResteasyClientBuilder().establishConnectionTimeout(12, TimeUnit.SECONDS).socketTimeout(12, TimeUnit.SECONDS).build();
            ResteasyWebTarget target = client.target(URL_BACKOFFICE + "/solicitudes");
            Response response = target.request().put(Entity.entity(request, "application/json"));
            try {
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
                }
                String jsonString = response.readEntity(String.class);
                
                
                ObjectMapper mapper = new ObjectMapper();
                JsonFactory factory = mapper.getFactory();
                JsonParser jp = factory.createJsonParser(jsonString);
                
                
                if (jsonString.charAt(0) == '{') {                	
                	JsonNode actualObj = mapper.readTree(jp);
                	
                	JsonNode jsonNode1 = actualObj.get("codEntidad");
                	codEntidad = jsonNode1.textValue();
                } else {
                	codEntidad = jsonString;
                }
                
                establecimiento.uid = codEntidad;
                
                new EstablecimientoDAO().update(establecimiento);
                log(1); // 1: Crear establecimiento
                System.out.println("Establecimiento updated!");
                
            } finally {
                response.close();
                client.close();
            }
        } catch (Exception e) {
        	ConsoleLogger.error("Error sending Solicitud de Alta de Establecimiento to Backoffice");
        }
        return codEntidad;
    }

    public static void log(int accion) {
    	try {
    		LogMessage msg = new LogMessage(accion);
        	
            ResteasyClient client = new ResteasyClientBuilder().establishConnectionTimeout(8, TimeUnit.SECONDS).socketTimeout(5, TimeUnit.SECONDS).build();
            ResteasyWebTarget target = client.target(URL_BACKOFFICE + "/logs");
            Response response = target.request().put(Entity.entity(msg, "application/json"));
            try {
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
                }
                System.out.println("Log Posted!");
                
            } finally {
                response.close();
                client.close();
            }
        } catch (Exception e) {
        	ConsoleLogger.error("Error sending Log to Backoffice");
        }
    }
}
