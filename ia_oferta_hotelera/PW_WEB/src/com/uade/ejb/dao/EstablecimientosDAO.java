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
import com.uade.ejb.dto.Response;

public class EstablecimientosDAO extends DAOBase {

	public EstablecimientosDAO(EntityManager em) {
		super(em);
	}
	
	public Collection<EstablecimientoDto> GetEstablecimientos() {
		List<EstablishmentEntity> establishments = getEstablecimientos();
		Collection<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
		
		
		for (Iterator<EstablishmentEntity> i = establishments.iterator(); i.hasNext();) {
			EstablishmentEntity item = i.next();
			EstablecimientoDto establecimiento = new EstablecimientoDto();
			establecimiento.direccion = item.address;
			establecimiento.id = item.idHotel;
			establecimiento.nombre = item.name;
			establecimiento.uid = item.uid;
			establecimiento.fotosEstablecimiento.add(item.establishmentPhoto);
		    establecimientos.add(establecimiento);
		}
		return establecimientos;
	}
	
	public Response CreateNewEstablishment(String name, String address, Collection<String> establishment_photo) {
		EstablishmentEntity establishment = searchEstablishment(name);
		
		if(establishment != null) {
			return new Response(false, null);
		}
		
		String photos = establishment_photo.toString();
		establishment = new EstablishmentEntity(name, address, photos);
		EntityTransaction transaction = em.getTransaction(); 
		transaction.begin();
		em.persist(establishment);
		transaction.commit();
		em.close();
		
		//Request a Backoffice
		//RequestEntity request = new RequestEntity(establishment, 1);
		
		
		return new Response(true, null);
	}

}
