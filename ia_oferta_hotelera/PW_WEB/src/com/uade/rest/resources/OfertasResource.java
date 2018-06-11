package com.uade.rest.resources;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.ServicioDto;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
import com.uade.ejb.services.PWService;

@Path("/ofertas")
@Stateless
public class OfertasResource {

    @EJB
    private PWService service;

    @GET
    @Path("/ofertas")
    @Produces("application/json")
    public Response ListOffers() {

        Response response = null;
        try {
        	response = service.ListOffers();
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        return response;
    }

    @POST
    @Path("/ofertas")
    @Produces("application/json")
    public Response getDetallesPaquete(@QueryParam("nombre_establecimiento") String nombre_establecimiento, 
    		@QueryParam("nombre") String nombre, @QueryParam("fechaDesde") Date fechaDesde, 
    		@QueryParam("fechaHasta") Date fechaHasta, 
    		@QueryParam("cuota") int cuota, @QueryParam("cantidad") int canitdad, 
    		@QueryParam("servicios") Collection<ServicioDto> servicios, 
    		@QueryParam("estado") int estado) {
        return service.createNewOffer(nombre_establecimiento, nombre, fechaDesde, fechaHasta, cuota, canitdad, servicios, estado);
    }
}
