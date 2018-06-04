package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.dto.EstablecimientoDto;

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

}
