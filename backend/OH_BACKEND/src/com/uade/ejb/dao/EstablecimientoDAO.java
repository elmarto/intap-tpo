package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.HotelEntity;
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
	
	public EstablecimientoDto CreateNewEstablishment(EstablecimientoEntity establecimiento) {
		HotelEntity hotel = (HotelEntity) buscar("HotelEntity", "id", "1");
		establecimiento.setHotel(hotel);
		guardar(establecimiento);
		System.out.println("Establecimiento saved.");
		return establecimiento.getDto();
	}

}
