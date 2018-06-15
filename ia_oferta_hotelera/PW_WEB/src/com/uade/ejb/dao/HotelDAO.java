package com.uade.ejb.dao;

import javax.persistence.EntityManager;

import com.uade.ejb.dto.HotelDto;
import com.uade.ejb.entities.HotelEntity;

public class HotelDAO extends DAOBase {
	
	public HotelDto Login(String email, String pass) {
		HotelEntity hotel = searchUserHotel(email, pass);
		HotelDto dto = new HotelDto();
		dto.email = hotel.getEmail();
		dto.id = hotel.getId();
		dto.pass = hotel.getPass();
		dto.photo = hotel.getPhoto();
		// dto.user = hotel.getUser();
		return dto;
	}

}
