package com.uade.rest.resources;

import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.services.PWService;

@Path("/hoteles")
@Stateless
public class HotelesResource {

    @EJB
    private PWService service;

    @GET
    @Path("/listado")
    @Produces("application/json")
    public Response buscarHoteles(@QueryParam("destino") String destino,
            @QueryParam("fechaDesde") String fechaDesde, @QueryParam("fechaHasta") String fechaHasta,
            @QueryParam("personas") int personas, @QueryParam("habitaciones") int habitaciones) {

        Response response = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

            BusquedaHotel busquedaHotel = new BusquedaHotel();
            busquedaHotel.setDestino(destino);
            busquedaHotel.setFechaEntrada(formatter.parse(fechaDesde));
            busquedaHotel.setFechaSalida(formatter.parse(fechaHasta));
            busquedaHotel.setPersonas(personas);
            busquedaHotel.setHabitaciones(habitaciones);

            response = service.buscarHoteles(busquedaHotel);
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        return response;
    }

    @GET
    @Path("/detalle")
    @Produces("application/json")
    public Response getDetallesHotel(@QueryParam("id") int idOferta) {
        return service.getDetallesHotel(idOferta);
    }
}
