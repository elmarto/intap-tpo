package com.uade.ejb.dto;

import com.uade.ejb.entities.CiudadEntity;

public class CiudadDto {
	public int id;
	public String city_name;
    
    public static CiudadDto fromEntity(CiudadEntity entity) {
    	CiudadDto dto = new CiudadDto();
    	dto.city_name = entity.getNombre();
    	return dto;
    }
}
