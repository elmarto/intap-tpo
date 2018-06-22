package com.uade.ejb.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaHoteleraDto;
import com.uade.ejb.dto.ServicioDto;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;

public class OfertaHoteleraDAO extends DAOBase {
	
	public Collection<OfertaHoteleraDto> ListOffers() {
		List<OfertaHoteleraEntity> offers = getOffers();
		Collection<OfertaHoteleraDto> ofertas = new ArrayList<OfertaHoteleraDto>();
		
		for (Iterator<OfertaHoteleraEntity> i = offers.iterator(); i.hasNext();) {
			OfertaHoteleraEntity item = i.next();
			ofertas.add(item.getDto());
		}
		return ofertas;
	}

	public OfertaHoteleraDto CreateNewOffer(OfertaHoteleraEntity oferta) {
		EstablecimientoEntity establecimiento = (EstablecimientoEntity) buscar("EstablecimientoEntity", "id", oferta.establecimiento.getId()+"");
		oferta.setEstablecimiento(establecimiento);
		guardar(oferta);
		System.out.println("OfertaHoteleraEntity saved.");
		return oferta.getDto();
		
//		if (!ValidateOffer(nombre_establecimiento, nombre, fechaDesde, fechaHasta, cuota, canitdad, servicios)) {
//			return new OHResponse(false, null);
//		}
//		
//		EstablecimientoEntity establishment = searchEstablishment(nombre_establecimiento);
//		if(establishment == null) {
//			return new OHResponse(false, null);
//		}
//		
//		ServiciosDAO servicioDAO = new ServiciosDAO();
//		boolean serviciosValidos = true;
//		for (ServicioDto servicioDto : servicios) {
//			serviciosValidos = serviciosValidos && servicioDAO.Validate(servicioDto);	
//		}
//		
//		if(serviciosValidos) {
//			OfertaHoteleraEntity offer = new OfertaHoteleraEntity(establishment, nombre, fechaHasta, fechaHasta, estado, null);
//			// OfferEntity offer = new OfferEntity(establishment, nombre, fechaDesde, fechaHasta, canitdad, (OfferServiceEntity) servicios);			
//			guardar(offer);
//			return new OHResponse(true, null);	
//		}
//		
		//return null;
	}
	
//	private boolean ValidateOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios) {
//		return (!nombre_establecimiento.isEmpty() && !nombre.isEmpty() && fechaDesde.after(fechaHasta) && (cuota > 0) && (canitdad > 0) && (servicios.size() > 0));  
//	}
}
