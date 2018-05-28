package com.uade.ejb.services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uade.ejb.dao.Destinos;
import com.uade.ejb.dao.OfertasHoteles;
import com.uade.ejb.dao.OfertasPaquetes;
import com.uade.ejb.dao.Reservas;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
import com.uade.ejb.dto.reserva.ReservaHotel;
import com.uade.ejb.dto.reserva.ReservaPaquete;

@Stateless
public class PWServiceBean implements PWService {

    @PersistenceContext(unitName = "PW")
    private EntityManager em;

    private OfertasHoteles ofertasHoteles;
    private OfertasPaquetes ofertasPaquetes;
    private Reservas reservas;
    private Destinos destinos;

    @PostConstruct
    public void init() {
        ofertasHoteles = new OfertasHoteles(em);
        ofertasPaquetes = new OfertasPaquetes(em);
        reservas = new Reservas(em);
        destinos = new Destinos(em);
    }

    @Override
    public Response buscarHoteles(BusquedaHotel busquedaHotel) {
        return ofertasHoteles.findByBusqueda(busquedaHotel);
    }

    @Override
    public Response getDetallesHotel(int idOferta) {
        return ofertasHoteles.getDetalle(idOferta);
    }

    @Override
    public Response buscarPaquetes(BusquedaPaquete busquedaPaquete) {
        return ofertasPaquetes.findByBusqueda(busquedaPaquete);
    }

    @Override
    public Response getDetallesPaquete(int idOferta) {
        return ofertasPaquetes.getDetalle(idOferta);
    }

    @Override
    public Response reservarHotel(ReservaHotel reserva) {
        return reservas.reservarHotel(reserva);
    }

    @Override
    public Response reservarPaquete(ReservaPaquete reserva) {
        return reservas.reservarPaquete(reserva);
    }

    @Override
    public Response getDestinos() {
        return destinos.getDestinos();
    }
}
