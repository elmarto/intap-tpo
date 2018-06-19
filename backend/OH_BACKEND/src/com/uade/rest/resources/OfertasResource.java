package com.uade.rest.resources;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.services.OHService;

@Path("/ofertas")
@Stateless
public class OfertasResource {

    @EJB
    private OHService service;

    @GET
    @Path("/")
    @Produces("application/json")
    public ArrayList<OfertaDto> ListOffers() {

    	ArrayList<OfertaDto> response = null;
        try {
        	response = service.ListOffers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

//    @POST
//    @Path("/")
//    @Produces("application/json")
//    public OfertaDto getDetallesPaquete(@QueryParam("nombre_establecimiento") String nombre_establecimiento, 
//    		@QueryParam("nombre") String nombre, @QueryParam("fechaDesde") Date fechaDesde, 
//    		@QueryParam("fechaHasta") Date fechaHasta, 
//    		@QueryParam("cuota") int cuota, @QueryParam("cantidad") int canitdad, 
//    		@QueryParam("servicios") Collection<ServicioDto> servicios, 
//    		@QueryParam("estado") int estado) {
//        return service.createNewOffer(nombre_establecimiento, nombre, fechaDesde, fechaHasta, cuota, canitdad, servicios, estado);
//    }
}
