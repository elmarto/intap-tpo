package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dto.DetalleHotel;
import com.uade.ejb.dto.MedioPago;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.entities.HotelEntity;
//import com.uade.ejb.dto.Oferta;
//import com.uade.ejb.entities.MedioPagoEntity;
//import com.uade.ejb.entities.OfertaEntity;
//import com.uade.ejb.entities.ServicioEntity;

public class OfertasHoteles extends DAOBase {

    public OfertasHoteles(EntityManager em) {
        super(em);
    }

    public Response findByBusqueda(BusquedaHotel busquedaHotel) {
        Response response = null;
//        try {
//            Query query = em.createQuery("from OfertaEntity o"
//                    + " where o.tipo = 'HOTEL'"
//                    + " and :fechaEntrada BETWEEN vigenciaDesde and vigenciaHasta"
//                    + " and :fechaSalida BETWEEN vigenciaDesde and vigenciaHasta"
//                    + " and :personas <= personas"
//            		+ " and :destino = destino.codigo");
//
//            query.setParameter("fechaEntrada", busquedaHotel.getFechaEntrada());
//            query.setParameter("fechaSalida", busquedaHotel.getFechaSalida());
//            query.setParameter("personas", busquedaHotel.getPersonas());
//            query.setParameter("destino", getCodigo(PREFIJO_DESTINO, busquedaHotel.getDestino()));
//
//            List<Oferta> ofertas = new ArrayList<>();
//            for (OfertaEntity ofertaEntity : (List<OfertaEntity>) query.getResultList()) {
//                if (ofertaEntity.getPrestador().getEstado() != 'R') {
//                    HotelEntity hotel = (HotelEntity) ofertaEntity.getPrestador();
//                    Oferta oferta = new Oferta();
//                    oferta.setCodigo(ofertaEntity.getCodigo());
//                    oferta.setImagen(hotel.getImagen());
//                    oferta.setDescripcion(hotel.getDescripcion());
//                    oferta.setPrecio(ofertaEntity.getPrecio());
//                    oferta.setDestino(ofertaEntity.getDestino().getDescripcion());
//                    oferta.setFechaDesde(ofertaEntity.getVigenciaDesde());
//                    oferta.setFechaHasta(ofertaEntity.getVigenciaHasta());
//                    oferta.setPersonas(ofertaEntity.getPersonas());
//                    List<String> servicios = new ArrayList<>();
//                    for (ServicioEntity servicioEntity : hotel.getServicios()) {
//                        servicios.add(servicioEntity.getDescripcion());
//                    }
//                    oferta.setServicios(servicios);
//                    ofertas.add(oferta);
//                }
//            }
//            response = new Response(true, ofertas);
//            Backoffice.log("Buscar Hoteles", "OK"); // TODO: enviar datos de la busqueda?
//        } catch (Exception e) {
//            e.printStackTrace();
//            response = new Response(false, e.getMessage());
//            Backoffice.log("Buscar Hoteles", "ERROR: " + e.getMessage());
//        }
        return response;
    }

    public Response getDetalle(int codigo) {
        Response response = null;
//        try {
//            OfertaEntity ofertaEntity = getOfertaHotel(codigo);
//            if (ofertaEntity != null) {
//                HotelEntity hotel = (HotelEntity) ofertaEntity.getPrestador();
//
//                DetalleHotel detalle = new DetalleHotel();
//                detalle.setCodigo(ofertaEntity.getCodigo());
//                detalle.setDestino(ofertaEntity.getDestino().getDescripcion());
//                detalle.setFechaDesde(ofertaEntity.getVigenciaDesde());
//                detalle.setFechaHasta(ofertaEntity.getVigenciaHasta());
//                detalle.setPersonas(ofertaEntity.getPersonas());
//                detalle.setNombreHotel(hotel.getNombre());
//                detalle.setFotoHabitacion(ofertaEntity.getImagen());
//                detalle.setDescripcionHabitacion(ofertaEntity.getDescripcion());
//                detalle.setPrecio(ofertaEntity.getPrecio());
//                detalle.setLatitud(ofertaEntity.getLatitud());
//                detalle.setLongitud(ofertaEntity.getLongitud());
//                detalle.setPoliticaCancelacion(ofertaEntity.getPoliticaCancelacion());
//                List<String> serviciosHotel = new ArrayList<>();
//                for (ServicioEntity servicioEntity : hotel.getServicios()) {
//                    serviciosHotel.add(servicioEntity.getDescripcion());
//                }
//                detalle.setServiciosHotel(serviciosHotel);
//                List<String> serviciosHabitacion = new ArrayList<>();
//                for (ServicioEntity servicioEntity : ofertaEntity.getServicios()) {
//                    serviciosHabitacion.add(servicioEntity.getDescripcion());
//                }
//                detalle.setServiciosHabitacion(serviciosHabitacion);
//                List<MedioPago> mediosPago = new ArrayList<>();
//                for (MedioPagoEntity medioPagoEntity : ofertaEntity.getMediosPago()) {
//                    MedioPago medioPago = new MedioPago();
//                    medioPago.setCodigo(medioPagoEntity.getCodigo());
//                    medioPago.setDescripcion(medioPagoEntity.getDescripcion());
//                    mediosPago.add(medioPago);
//                }
//                detalle.setMediosPago(mediosPago);
//                response = new Response(true, detalle);
//                Backoffice.log("Ver Detalle Hotel", "OK");
//            } else {
//                response = new Response(false, "No se encontró la oferta solicitada");
//                Backoffice.log("Ver Detalle Hotel", "ERROR: No se encontró la oferta solicitada");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response = new Response(false, e.getMessage());
//            Backoffice.log("Ver Detalle Hotel", "ERROR: " + e.getMessage());
//        }
        return response;
    }
}
