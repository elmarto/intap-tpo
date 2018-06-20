package com.uade.ejb.dao;

import com.uade.ejb.dto.FotoDto;
import com.uade.ejb.entities.FotoEntity;

public class FotoDAO extends DAOBase {
	public FotoDto createMapa(FotoEntity entity) {
		guardar(entity);
		System.out.println("Foto saved");
		return entity.getDto();
	}
}
