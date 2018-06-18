// EJEMPLO DE PROCESAR MENSAJES DE COLAS PARA PORTAL WEB


//package com.uade.ejb.dao;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import javax.persistence.EntityManager;
//
//import com.uade.ejb.backoffice.Backoffice;
//import com.uade.ejb.entities.AgenciaEntity;
//import com.uade.ejb.entities.DestinoEntity;
//import com.uade.ejb.entities.HotelEntity;
//import com.uade.ejb.entities.MedioPagoEntity;
//import com.uade.ejb.entities.OfertaEntity;
//import com.uade.ejb.entities.ServicioEntity;
//import com.uade.ejb.mdb.messages.OfertaHotelMessage;
//import com.uade.ejb.mdb.messages.OfertaPaqueteMessage;
//
//public class Mensajes extends DAOBase {
//
//    public Mensajes(EntityManager em) {
//        super(em);
//    }
//
//    public void procesarMensaje(OfertaHotelMessage ofertaHotelMessage) throws ParseException {
//        // Hotel
//        HotelEntity hotelEntity = em.find(HotelEntity.class, ofertaHotelMessage.getCodigoPrestador());
//        if (hotelEntity == null) {
//            hotelEntity = new HotelEntity();
//            hotelEntity.setCodigo(ofertaHotelMessage.getCodigoPrestador());
//            hotelEntity.setEstado(Backoffice.getEstadoProveedor(hotelEntity.getCodigo()));
//            hotelEntity.setEmail(ofertaHotelMessage.getEmailHotel());
//            hotelEntity.setNombre(ofertaHotelMessage.getNombreHotel().trim());
//            hotelEntity.setDescripcion(ofertaHotelMessage.getDescripcionHotel());
//            hotelEntity.setImagen(ofertaHotelMessage.getFotoHotel());
//        }
//
//        // Servicios de hotel
//        for (String servicioHotel : ofertaHotelMessage.getServiciosHotel()) {
//            ServicioEntity servicioEntity = getServicio(servicioHotel);
//            hotelEntity.getServicios().add(servicioEntity);
//        }
//
//        // Destino
//        DestinoEntity destinoEntity = getDestino(ofertaHotelMessage.getDestino());
//
//        // Oferta
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//
//        OfertaEntity ofertaHotelEntity = new OfertaEntity();
//        ofertaHotelEntity.setTipo("HOTEL");
//        ofertaHotelEntity.setPrestador(hotelEntity);
//        ofertaHotelEntity.setDestino(destinoEntity);
//        ofertaHotelEntity.setVigenciaDesde(formatter.parse(ofertaHotelMessage.getFechaDesde()));
//        ofertaHotelEntity.setVigenciaHasta(formatter.parse(ofertaHotelMessage.getFechaHasta()));
//        ofertaHotelEntity.setLatitud(ofertaHotelMessage.getLatitud());
//        ofertaHotelEntity.setLongitud(ofertaHotelMessage.getLongitud());
//        ofertaHotelEntity.setDescripcion(ofertaHotelMessage.getDescripcionHabitacion());
//        ofertaHotelEntity.setImagen(ofertaHotelMessage.getFotoHabitacion());
//        ofertaHotelEntity.setPrecio(ofertaHotelMessage.getPrecio());
//        ofertaHotelEntity.setPersonas(ofertaHotelMessage.getCantidadPersonas());
//        ofertaHotelEntity.setPoliticaCancelacion(ofertaHotelMessage.getPoliticaCancelacion());
//        ofertaHotelEntity.setCupo(ofertaHotelMessage.getCupo());
//
//        // Medios de pago
//        for (Integer medioPago : ofertaHotelMessage.getMediosPago()) {
//            MedioPagoEntity medioPagoEntity = getMedioPago(medioPago);
//            ofertaHotelEntity.getMediosPago().add(medioPagoEntity);
//        }
//
//        // Servicios de habitacion
//        for (String servicioHabitacion : ofertaHotelMessage.getServiciosHabitacion()) {
//            ServicioEntity servicioEntity = getServicio(servicioHabitacion);
//            ofertaHotelEntity.getServicios().add(servicioEntity);
//        }
//
//        em.persist(ofertaHotelEntity);
//        em.flush();
//
//        Backoffice.log("Nueva Oferta Hotel", "OK"); // TODO: enviar datos de la oferta?
//    }
//
//    public void procesarMensaje(OfertaPaqueteMessage ofertaPaqueteMessage) throws ParseException {
//        // Agencia
//        AgenciaEntity agenciaEntity = em.find(AgenciaEntity.class, ofertaPaqueteMessage.getCodigoPrestador());
//        if (agenciaEntity == null) {
//            agenciaEntity = new AgenciaEntity();
//            agenciaEntity.setCodigo(ofertaPaqueteMessage.getCodigoPrestador());
//            agenciaEntity.setEstado(Backoffice.getEstadoProveedor(agenciaEntity.getCodigo()));
//            agenciaEntity.setEmail(ofertaPaqueteMessage.getEmailAgencia().trim());
//        }
//
//        // Destino
//        DestinoEntity destinoEntity = getDestino(ofertaPaqueteMessage.getDestino());
//
//        // Oferta
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//
//        OfertaEntity ofertaPaqueteEntity = new OfertaEntity();
//        ofertaPaqueteEntity.setTipo("PAQUETE");
//        ofertaPaqueteEntity.setPrestador(agenciaEntity);
//        ofertaPaqueteEntity.setDestino(destinoEntity);
//        ofertaPaqueteEntity.setVigenciaDesde(formatter.parse(ofertaPaqueteMessage.getFechaDesde()));
//        ofertaPaqueteEntity.setVigenciaHasta(formatter.parse(ofertaPaqueteMessage.getFechaHasta()));
//        ofertaPaqueteEntity.setDescripcion(ofertaPaqueteMessage.getDescripcion());
//        ofertaPaqueteEntity.setLatitud(ofertaPaqueteMessage.getLatitud());
//        ofertaPaqueteEntity.setLongitud(ofertaPaqueteMessage.getLongitud());
//        ofertaPaqueteEntity.setImagen(ofertaPaqueteMessage.getFoto());
//        ofertaPaqueteEntity.setPrecio(ofertaPaqueteMessage.getPrecio());
//        ofertaPaqueteEntity.setPersonas(ofertaPaqueteMessage.getCantidadPersonas());
//        ofertaPaqueteEntity.setPoliticaCancelacion(ofertaPaqueteMessage.getPoliticaCancelacion());
//        ofertaPaqueteEntity.setCupo(ofertaPaqueteMessage.getCupo());
//
//        // Medios de pago
//        for (Integer medioPago : ofertaPaqueteMessage.getMediosPago()) {
//            MedioPagoEntity medioPagoEntity = getMedioPago(medioPago);
//            ofertaPaqueteEntity.getMediosPago().add(medioPagoEntity);
//        }
//
//        // Servicios del paquete
//        for (String servicioPaquete : ofertaPaqueteMessage.getServicios()) {
//            ServicioEntity servicioEntity = getServicio(servicioPaquete);
//            ofertaPaqueteEntity.getServicios().add(servicioEntity);
//        }
//
//        em.persist(ofertaPaqueteEntity);
//        em.flush();
//
//        Backoffice.log("Nueva Oferta Paquete", "OK"); // TODO: enviar datos de la oferta?
//    }
//}
