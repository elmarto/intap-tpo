package com.uade.ejb.backoffice;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.ejb.soap.PrestadorAutorizadoService;
import com.uade.ejb.soap.ServiciosBO_002fPrestadorAutorizado;
import com.uade.ejb.soap.SolicitudDTO;

public class Backoffice {

    private static final String URL_PROVEEDORES = "http://192.168.0.100:8080/TPO_BO_EJB/ServiciosBO/PrestadorAutorizado";
    private static final String URL_LOG = "http://192.168.0.100:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog";

    public static char getEstadoProveedor(int codigoPrestador) {
        char estado = 'P';
        try {
            PrestadorAutorizadoService service = new PrestadorAutorizadoService();
            ServiciosBO_002fPrestadorAutorizado port = service.getServiciosBO_002fPrestadorAutorizadoPort();
            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL_PROVEEDORES);
            SolicitudDTO solicitud = port.getPrestadorAutorizado(codigoPrestador);
            if (solicitud != null) {
                String estadoPrestador = solicitud.getEstado();
                if (estadoPrestador != null) {
                    estado = Character.toUpperCase(estadoPrestador.charAt(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
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
