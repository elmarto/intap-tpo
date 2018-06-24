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
	}
}
