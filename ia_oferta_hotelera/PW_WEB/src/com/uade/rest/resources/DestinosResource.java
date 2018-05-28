package com.uade.rest.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.uade.ejb.dto.Response;
import com.uade.ejb.services.PWService;

@Path("/destinos")
@Stateless
public class DestinosResource {

    @EJB
    private PWService service;

    @GET
    @Path("/listado")
    @Produces("application/json")
    public Response getDestinos() {
        return service.getDestinos();
    }
}
