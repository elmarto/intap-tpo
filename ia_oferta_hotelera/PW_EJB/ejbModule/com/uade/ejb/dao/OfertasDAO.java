package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;

import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.entities.OfferEntity;

public class OfertasDAO extends DAOBase {

	public OfertasDAO(EntityManager em) {
		super(em);
	}
	
	public Collection<OfertaDto> GetAllOffers() {
		Collection<OfferEntity> offers = getOffers();
		Collection<OfertaDto> ofertas = new ArrayList<OfertaDto>();
		
		for (Iterator<OfferEntity> i = offers.iterator(); i.hasNext();) {
			OfferEntity item = i.next();
			OfertaDto oferta = new OfertaDto();
			oferta.cupo = item.quantity;
			oferta.id= item.id;
			oferta.fechaDesde = item.dateFrom;
			oferta.fechaHasta = item.dateEnd;
			oferta.mediosDePago = item.paymentMethods;
			oferta.nombre = item.name;
			oferta.politicas = item.policies;
			oferta.precio = item.price;
			oferta.tipoHabitacion = item.roomType;
			oferta.establecimiento = EstablecimientoDto.FromEntity(item.establishment);
			oferta.servicios = item.getServicesString();			
			
		    ofertas.add(oferta);
		}
		return ofertas;
	}

}
