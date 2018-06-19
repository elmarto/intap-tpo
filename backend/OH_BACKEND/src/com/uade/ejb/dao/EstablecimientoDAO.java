package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.dto.EstablecimientoDto;

public class EstablecimientoDAO extends DAOBase {

	public EstablecimientoDAO() {}

	public Collection<EstablecimientoDto> GetEstablecimientos() {
		List<EstablecimientoEntity> establishments = getEstablecimientos();
		Collection<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
		
		for (Iterator<EstablecimientoEntity> i = establishments.iterator(); i.hasNext();) {
			EstablecimientoEntity item = i.next();
		    establecimientos.add(item.getDto());
		}
		return establecimientos;
	}
	
	public EstablecimientoDto CreateNewEstablishment(EstablecimientoEntity establishment) {
		guardar(establishment);
		System.out.println("Entity saved.");
		return establishment.getDto();
	}

}
