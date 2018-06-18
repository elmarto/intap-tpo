package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.hibernate.JPAUtility;
import com.uade.ejb.dto.EstablecimientoDto;

public class EstablecimientosDAO extends DAOBase {

	public EstablecimientosDAO() {
	}

	public Collection<EstablecimientoDto> GetEstablecimientos() {
		Collection<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
		EstablecimientoDto dto = new EstablecimientoDto();
		dto.nombre = "Sheraton";
		dto.direccion = "Av. 9 de julio 235";
		dto.uid = "121";
		establecimientos.add(dto);
		/*
		List<EstablishmentEntity> establishments = getEstablecimientos();
		Collection<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
		
		for (Iterator<EstablishmentEntity> i = establishments.iterator(); i.hasNext();) {
			EstablishmentEntity item = i.next();
		    establecimientos.add(item.getDto());
		}
		*/
		return establecimientos;
	}
	
	public EstablecimientoDto CreateNewEstablishment(EstablishmentEntity establishment) {
		guardar(establishment);
		System.out.println("Entity saved.");
		return establishment.getDto();
	}

}
