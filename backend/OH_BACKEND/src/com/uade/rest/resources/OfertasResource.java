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
import com.uade.ejb.dto.OfertaHoteleraDto;
import com.uade.ejb.services.OHService;

@Path("/ofertas")
@Stateless
public class OfertasResource {

    @EJB
    private OHService service;

    @GET
    @Path("/")
    @Produces("application/json")
    public ArrayList<OfertaHoteleraDto> ListOffers() {

    	ArrayList<OfertaHoteleraDto> response = null;
        try {
        	response = service.ListOffers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public OfertaHoteleraDto CreateNewOferta(OfertaHoteleraDto oferta) {
        return service.createNewOffer(oferta);
    }
}
