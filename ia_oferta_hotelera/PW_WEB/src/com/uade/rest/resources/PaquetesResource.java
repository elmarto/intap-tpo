package com.uade.rest.resources;

import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
import com.uade.ejb.services.PWService;

@Path("/paquetes")
@Stateless
public class PaquetesResource {

    @EJB
    private PWService service;

    @GET
    @Path("/listado")
    @Produces("application/json")
    public Response buscarPaquetes(@QueryParam("destino") String destino,
            @QueryParam("fechaDesde") String fechaDesde, @QueryParam("fechaHasta") String fechaHasta,
            @QueryParam("personas") int personas) {

        Response response = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

            BusquedaPaquete busquedaPaquete = new BusquedaPaquete();
            busquedaPaquete.setDestino(destino);
            busquedaPaquete.setFechaSalidaDesde(formatter.parse(fechaDesde));
            busquedaPaquete.setFechaSalidaHasta(formatter.parse(fechaHasta));
            busquedaPaquete.setPersonas(personas);

            response = service.buscarPaquetes(busquedaPaquete);
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        return response;
    }

    @GET
    @Path("/detalle")
    @Produces("application/json")
    public Response getDetallesPaquete(@QueryParam("id") int idOferta) {
        return service.getDetallesPaquete(idOferta);
    }
}
