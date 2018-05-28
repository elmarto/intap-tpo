package com.uade.ejb.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.reserva.ReservaHotel;
import com.uade.ejb.dto.reserva.ReservaPaquete;
import com.uade.ejb.entities.MedioPagoEntity;
import com.uade.ejb.entities.OfertaEntity;
import com.uade.ejb.entities.ReservaHotelEntity;
import com.uade.ejb.entities.ReservaPaqueteEntity;

public class Reservas extends DAOBase {

    public Reservas(EntityManager em) {
        super(em);
    }

    public Response reservarHotel(ReservaHotel reserva) {
        Response response = null;
        try {
            OfertaEntity ofertaEntity = getOfertaHotel(reserva.getIdOferta());
            if (ofertaEntity != null) {
                if (checkPrestadorHailitado(ofertaEntity.getPrestador())) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                    Date fechaDesde = formatter.parse(reserva.getFechaDesde());
                    Date fechaHasta = formatter.parse(reserva.getFechaHasta());
                    int cupo = getCupoHotel(ofertaEntity, fechaDesde, fechaHasta);
                    if (cupo >= reserva.getCantidadHabitaciones()) {
                        MedioPagoEntity medioPago = getMedioPago(reserva.getMedioPago());
                        if (ofertaEntity.getMediosPago().contains(medioPago)) {
                            ReservaHotelEntity reservaEntity = new ReservaHotelEntity();
                            reservaEntity.setOferta(ofertaEntity);
                            reservaEntity.setFechaDesde(fechaDesde);
                            reservaEntity.setFechaHasta(fechaHasta);
                            reservaEntity.setCantidad(reserva.getCantidadHabitaciones());
                            reservaEntity.setMedioPago(medioPago);
                            reservaEntity.setMail(reserva.getMail());
                            em.persist(reservaEntity);
                            em.flush();
                            response = new Response(true, "Reserva exitosa");
                        } else {
                            response = new Response(false, "La oferta no acepta el medio de pago");
                        }
                    } else {
                        response = new Response(false, "No hay cupo en la haitación seleccionada");
                    }
                } else {
                    response = new Response(false, "El hotel no está habilitado");
                }
            } else {
                response = new Response(false, "Oferta inválida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        if (response.getEstado()) {
            Backoffice.log("Reservar Hotel", "OK"); // TODO: enviar datos de la reserva?
        } else {
            Backoffice.log("Reservar Hotel", "ERROR: " + response.getRespuesta());
        }
        return response;
    }

    public Response reservarPaquete(ReservaPaquete reserva) {
        Response response = null;
        try {
            OfertaEntity ofertaEntity = getOfertaPaquete(reserva.getIdOferta());
            if (ofertaEntity != null) {
                if (checkPrestadorHailitado(ofertaEntity.getPrestador())) {
                    int cupo = getCupoPaquete(ofertaEntity);
                    if (cupo >= reserva.getCantidad()) {
                        MedioPagoEntity medioPago = getMedioPago(reserva.getMedioPago());
                        if (ofertaEntity.getMediosPago().contains(medioPago)) {
                            ReservaPaqueteEntity reservaEntity = new ReservaPaqueteEntity();
                            reservaEntity.setOferta(ofertaEntity);
                            reservaEntity.setCantidad(reserva.getCantidad());
                            reservaEntity.setMedioPago(medioPago);
                            reservaEntity.setMail(reserva.getMail());
                            em.persist(reservaEntity);
                            em.flush();
                            response = new Response(true, "Reserva exitosa");
                        } else {
                            response = new Response(false, "La oferta no acepta el medio de pago seleccionado");
                        }
                    } else {
                        response = new Response(false, "No hay cupo en el paquete seleccionado");
                    }
                } else {
                    response = new Response(false, "La agencia no está habilitada");
                }
            } else {
                response = new Response(false, "Oferta inválida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        if (response.getEstado()) {
            Backoffice.log("Reservar Paquete", "OK"); // TODO: enviar datos de la reserva?
        } else {
            Backoffice.log("Reservar Paquete", "ERROR: " + response.getRespuesta());
        }
        return response;
    }

    private int getCupoHotel(OfertaEntity oferta, Date fechaDesde, Date fechaHasta) {
        Query query = em.createQuery("from ReservaHotelEntity r"
                + " where r.oferta = :oferta"
                + " and r.fechaDesde >= :fechaDesde"
                + " and r.fechaHasta <= :fechaHasta");
        query.setParameter("oferta", oferta);
        query.setParameter("fechaDesde", fechaDesde);
        query.setParameter("fechaHasta", fechaHasta);

        List<ReservaHotelEntity> reservas = query.getResultList();

        int maxReservas = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(fechaDesde);
        Calendar end = Calendar.getInstance();
        end.setTime(fechaHasta);
        for (Date fecha = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), fecha = start.getTime()) {
            int reservasDia = 0;
            for (ReservaHotelEntity reserva : reservas) {
                if (fecha.after(reserva.getFechaDesde()) && fecha.before(reserva.getFechaHasta())) {
                    reservasDia += reserva.getCantidad();
                }
            }
            if (reservasDia > maxReservas) {
                maxReservas = reservasDia;
            }
        }
        return oferta.getCupo() - maxReservas;
    }

    private int getCupoPaquete(OfertaEntity oferta) {
        Query query = em.createQuery("from ReservaPaqueteEntity r"
                + " where r.oferta = :oferta");
        query.setParameter("oferta", oferta);

        int reservas = 0;
        for (ReservaPaqueteEntity reservaEntity : (List<ReservaPaqueteEntity>) query.getResultList()) {
            reservas += reservaEntity.getCantidad();
        }

        return oferta.getCupo() - reservas;
    }
}
