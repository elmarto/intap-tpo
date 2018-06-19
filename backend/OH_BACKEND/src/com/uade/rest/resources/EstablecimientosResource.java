package com.uade.rest.resources;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.services.OHService;

// http://localhost:8080/OH_BACKEND/rest/establecimientos/
@Path("/establecimientos")
@Stateless
public class EstablecimientosResource {

    @EJB
    private OHService service;

    @GET
    @Path("/")
    @Produces("application/json")
    public ArrayList<EstablecimientoDto> getAllEstablishments() {
    	ArrayList<EstablecimientoDto> response = null;
        try {
        	response = service.GetEstablecimientos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public EstablecimientoDto CreateNewEstablishment(EstablecimientoDto establecimiento) {
        return service.CreateNewEstablishment(establecimiento);
    }

    
    // CREAR MOCK
	@GET
	@Path("/crear")
	@Produces("application/json")
	public EstablecimientoDto CreateNewEstablishment() {
		EstablecimientoDto e = new EstablecimientoDto();
		e.nombre = "Mi nuevo nuevo establecimiento";
	    return service.CreateNewEstablishment(e);
	}
}
