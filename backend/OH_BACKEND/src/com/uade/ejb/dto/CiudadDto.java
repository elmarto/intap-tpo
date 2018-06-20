package com.uade.ejb.dto;

import com.uade.ejb.entities.CiudadEntity;

public class CiudadDto {
	public int id;
	public String nombre;
    
    public static CiudadDto fromEntity(CiudadEntity entity) {
    	CiudadDto dto = new CiudadDto();
    	dto.nombre = entity.getNombre();
    	return dto;
    }
}
