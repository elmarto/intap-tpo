package com.uade.ejb.dao;

import com.uade.ejb.dto.MapaDto;
import com.uade.ejb.entities.MapaEntity;

public class MapaDAO extends DAOBase {
	public MapaDto createMapa(MapaEntity entity) {
		guardar(entity);
		System.out.println("Mapa saved");
		return entity.getDto();
	}
}
