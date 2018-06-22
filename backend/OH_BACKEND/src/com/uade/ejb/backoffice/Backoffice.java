package com.uade.ejb.backoffice;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.ejb.dto.EstablecimientoDto;

public class Backoffice {

    private static final String URL_PROVEEDORES = "http://192.168.0.100:8080/TPO_BO_EJB/rest/Solicitud/EnviarSolicitud";
    private static final Strgring URL_LOG = "http://192.168.0.100:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog";

    public static SolicitudHoteleraResponse enviarSolicitudHotelera(EstablecimientoDto establecimiento) {
        try {
        	SolicitudHoteleraRequest request = new SolicitudHoteleraRequest();
        	request.direccion = establecimiento.direccion;
        	request.nombre = establecimiento.nombre;
        	request.tipo = 1; // Solicitud OH
        	
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(URL_PROVEEDORES);
            Response response = target.request().post(Entity.entity(request, "application/json"));
            try {
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
                }
                SolicitudHoteleraResponse solicitudResponse = response.readEntity(SolicitudHoteleraResponse.class);
                establecimiento.uid = solicitudResponse.codEntidad;
                
            } finally {
                response.close();
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void log(String servicio, String observacion) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            URL url = new URL(URL_LOG);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");

            LogMessage msg = new LogMessage();
            msg.setPlataformaEnvia("PW");
            msg.setPlataformaRecibe("BO");
            msg.setServicio(servicio);
            msg.setObservacion(observacion);

            IOUtils.write(mapper.writeValueAsString(msg), urlConnection.getOutputStream());
            String response = IOUtils.toString(urlConnection.getInputStream());

            System.out.println("LOG Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
