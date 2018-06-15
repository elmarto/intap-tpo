package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.entities.RequestEntity;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OHResponse;

public class EstablecimientosDAO extends DAOBase {

	public EstablecimientosDAO(EntityManager em) {
		super(em);
	}
	
	public Collection<EstablecimientoDto> GetEstablecimientos() {
		List<EstablishmentEntity> establishments = getEstablecimientos();
		Collection<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
		
		for (Iterator<EstablishmentEntity> i = establishments.iterator(); i.hasNext();) {
			EstablishmentEntity item = i.next();
		    establecimientos.add(item.getDto());
		}
		return establecimientos;
	}
	
//	public EstablecimientoDto CreateNewEstablishment(String name, String address, Collection<String> establishment_photo) {
//		EstablishmentEntity establishment = null;
////		establishment = searchEstablishment(name);
////		
////		if(establishment != null) {
////			return null;
////		}
//		
//		
//		
//		// String photos = establishment_photo.toString();
//		establishment = new EstablishmentEntity(name, address, "");
//		EntityTransaction transaction = em.getTransaction(); 
//		transaction.begin();
//		em.persist(establishment);
//		transaction.commit();
//		em.close();
//		
//		EstablecimientoDto establecimientoDto = new EstablecimientoDto();
//		establecimientoDto.nombre = name;
//		establecimientoDto.direccion = address;
//		
//		return establecimientoDto;
//	}

}
