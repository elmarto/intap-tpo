package com.uade.ejb.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.ServicioDto;
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

	public Response CreateNewOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios, int estado) {
		if (!ValidateOffer(nombre_establecimiento, nombre, fechaDesde, fechaHasta, cuota, canitdad, servicios)) {
			return new Response(false, null);
		}
		
		EstablishmentEntity establishment = searchEstablishment(nombre_establecimiento);
		if(establishment == null) {
			return new Response(false, null);
		}
		
		ServiciosDAO servicioDAO = new ServiciosDAO();
		boolean serviciosValidos = true;
		for (ServicioDto servicioDto : servicios) {
			serviciosValidos = serviciosValidos && servicioDAO.Validate(servicioDto);	
		}
		
		if(serviciosValidos) {
			OfferEntity offer = new OfferEntity(establishment, nombre, fechaHasta, fechaHasta, estado, null);
			// OfferEntity offer = new OfferEntity(establishment, nombre, fechaDesde, fechaHasta, canitdad, (OfferServiceEntity) servicios);
			
			EntityTransaction transaction = em.getTransaction(); 
			transaction.begin();
			em.persist(offer);
			transaction.commit();
			em.close();
			return new Response(true, null);	
		}
		
		return new Response(false, null);
	}
	
	private boolean ValidateOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios) {
		return (!nombre_establecimiento.isEmpty() && !nombre.isEmpty() && fechaDesde.after(fechaHasta) && (cuota > 0) && (canitdad > 0) && (servicios.size() > 0));  
	}
}
