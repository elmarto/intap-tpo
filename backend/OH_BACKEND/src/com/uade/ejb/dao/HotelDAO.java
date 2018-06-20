package com.uade.ejb.dao;

import com.uade.ejb.dto.HotelDto;
import com.uade.ejb.entities.HotelEntity;

public class HotelDAO extends DAOBase {
	public HotelDto createHotel(HotelEntity hotel) {
		guardar(hotel);
		System.out.println("Hotel saved");
		return hotel.getDto();
	}
}
