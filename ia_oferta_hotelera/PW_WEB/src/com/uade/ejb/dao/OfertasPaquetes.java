package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dto.DetallePaquete;
import com.uade.ejb.dto.MedioPago;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
//import com.uade.ejb.dto.Oferta;
//import com.uade.ejb.entities.MedioPagoEntity;
//import com.uade.ejb.entities.OfertaEntity;
//import com.uade.ejb.entities.ServicioEntity;

public class OfertasPaquetes extends DAOBase {

    public Response findByBusqueda(BusquedaPaquete busquedaPaquete) {
        Response response = null;
//        try {
//            Query query = em.createQuery("from OfertaEntity o"
//                    + " where o.tipo = 'PAQUETE'"
//                    + " and o.vigenciaDesde <= :fechaSalidaHasta"
//                    + " and o.vigenciaHasta >= :fechaSalidaDesde"
//                    + " and o.personas >= :personas"
//                    + " and o.destino.codigo = :destino");
//
//            query.setParameter("fechaSalidaDesde", busquedaPaquete.getFechaSalidaDesde());
//            query.setParameter("fechaSalidaHasta", busquedaPaquete.getFechaSalidaHasta());
//            query.setParameter("personas", busquedaPaquete.getPersonas());
//            query.setParameter("destino", getCodigo(PREFIJO_DESTINO, busquedaPaquete.getDestino()));
//            
//            List<Oferta> ofertas = new ArrayList<>();
//            for (OfertaEntity ofertaEntity : (List<OfertaEntity>) query.getResultList()) {
//                if (ofertaEntity.getPrestador().getEstado() != 'R') {
//                    Oferta oferta = new Oferta();
//                    oferta.setCodigo(ofertaEntity.getCodigo());
//                    oferta.setImagen(ofertaEntity.getImagen());
//                    oferta.setDescripcion(ofertaEntity.getDescripcion());
//                    oferta.setPrecio(ofertaEntity.getPrecio());
//                    oferta.setDestino(ofertaEntity.getDestino().getDescripcion());
//                    oferta.setFechaDesde(ofertaEntity.getVigenciaDesde());
//                    oferta.setFechaHasta(ofertaEntity.getVigenciaHasta());
//                    oferta.setPersonas(ofertaEntity.getPersonas());
//                    List<String> servicios = new ArrayList<>();
//                    for (ServicioEntity servicioEntity : ofertaEntity.getServicios()) {
//                        servicios.add(servicioEntity.getDescripcion());
//                    }
//                    oferta.setServicios(servicios);
//                    ofertas.add(oferta);
//                }
//            }
//            response = new Response(true, ofertas);
//            Backoffice.log("Buscar Paquetes", "OK"); // TODO: enviar datos de la busqueda?
//        } catch (Exception e) {
//            e.printStackTrace();
//            response = new Response(false, e.getMessage());
//            Backoffice.log("Buscar Paquetes", "ERROR: " + e.getMessage());
//        }
//        return response;
//    }
//
//    public Response getDetalle(int codigo) {
//        Response response = null;
//        try {
//            OfertaEntity ofertaEntity = getOfertaPaquete(codigo);
//            if (ofertaEntity != null) {
//                DetallePaquete detalle = new DetallePaquete();
//                detalle.setCodigo(ofertaEntity.getCodigo());
//                detalle.setDestino(ofertaEntity.getDestino().getDescripcion());
//                detalle.setFechaDesde(ofertaEntity.getVigenciaDesde());
//                detalle.setFechaHasta(ofertaEntity.getVigenciaHasta());
//                detalle.setPersonas(ofertaEntity.getPersonas());
//                detalle.setFoto(ofertaEntity.getImagen());
//                detalle.setDescripcion(ofertaEntity.getDescripcion());
//                detalle.setPrecio(ofertaEntity.getPrecio());
//                detalle.setLatitud(ofertaEntity.getLatitud());
//                detalle.setLongitud(ofertaEntity.getLongitud());
//                detalle.setPoliticaCancelacion(ofertaEntity.getPoliticaCancelacion());
//                List<String> servicios = new ArrayList<>();
//                for (ServicioEntity servicioEntity : ofertaEntity.getServicios()) {
//                    servicios.add(servicioEntity.getDescripcion());
//                }
//                detalle.setServicios(servicios);
//                List<MedioPago> mediosPago = new ArrayList<>();
//                for (MedioPagoEntity medioPagoEntity : ofertaEntity.getMediosPago()) {
//                    MedioPago medioPago = new MedioPago();
//                    medioPago.setCodigo(medioPagoEntity.getCodigo());
//                    medioPago.setDescripcion(medioPagoEntity.getDescripcion());
//                    mediosPago.add(medioPago);
//                }
//                detalle.setMediosPago(mediosPago);
//                response = new Response(true, detalle);
//                Backoffice.log("Ver Detalle Paquete", "OK");
//            } else {
//                response = new Response(false, "No se encontró la oferta solicitada");
//                Backoffice.log("Ver Detalle Paquete", "ERROR: No se encontró la oferta solicitada");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response = new Response(false, e.getMessage());
//            Backoffice.log("Ver Detalle Paquete", "ERROR: " + e.getMessage());
//        }
        return response;
    }
}
