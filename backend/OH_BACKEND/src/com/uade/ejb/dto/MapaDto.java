package com.uade.ejb.dto;

import com.uade.ejb.entities.MapaEntity;

public class MapaDto {
	public int id;
	public String lat;
	public String lon;
    
    public static MapaDto fromEntity(MapaEntity entity) {
    	MapaDto dto = new MapaDto();
    	dto.lat = entity.getLat();
    	dto.lon = entity.getLon();
    	return dto;
    }
}
