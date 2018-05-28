package com.uade.rest.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.reserva.ReservaHotel;
import com.uade.ejb.dto.reserva.ReservaPaquete;
import com.uade.ejb.services.PWService;

@Path("/reservas")
@Stateless
public class ReservasResource {

    @EJB
    private PWService service;

    @POST
    @Path("/hotel")
    @Produces("application/json")
    public Response reservarHotel(@QueryParam("id") int idOferta, @QueryParam("fechaDesde") String fechaDesde,
            @QueryParam("fechaHasta") String fechaHasta, @QueryParam("cantidad") int cantidadHabitaciones,
            @QueryParam("medioPago") int medioPago, @QueryParam("mail") String mail) {

        ReservaHotel reserva = new ReservaHotel();
        reserva.setIdOferta(idOferta);
        reserva.setFechaDesde(fechaDesde);
        reserva.setFechaHasta(fechaHasta);
        reserva.setCantidadHabitaciones(cantidadHabitaciones);
        reserva.setMedioPago(medioPago);
        reserva.setMail(mail);
        return service.reservarHotel(reserva);
    }

    @POST
    @Path("/paquete")
    @Produces("application/json")
    public Response reservarPaquete(@QueryParam("id") int idOferta, @QueryParam("cantidad") int cantidad,
            @QueryParam("medioPago") int medioPago, @QueryParam("mail") String mail) {

        ReservaPaquete reserva = new ReservaPaquete();
        reserva.setIdOferta(idOferta);
        reserva.setCantidad(cantidad);
        reserva.setMedioPago(medioPago);
        reserva.setMail(mail);

        return service.reservarPaquete(reserva);
    }
}
