package com.uade.rest.resources;

import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

 import com.uade.ejb.dto.EstablecimientoDto;
 import com.uade.ejb.dto.Response;
// import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.services.PWService;

// http://myip:8080/OH_BACKEND/rest/establecimientos/
@Path("/establecimientos")
@Stateless
public class EstablecimientosResource {

    @EJB
    private PWService service;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllEstablishments() {
        Response response = null;
        try {
        	response = service.GetEstablecimientos();
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        return response;
    }
//
//    @POST
//    @Path("/")
//    @Produces("application/json")
//    public Response CreateNewEstablishment(@QueryParam("establecimiento") EstablecimientoDto establecimiento) {
//        return service.CreateNewEstablishment(establecimiento);
//    }
}
