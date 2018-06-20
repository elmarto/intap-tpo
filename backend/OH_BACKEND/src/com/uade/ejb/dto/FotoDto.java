package com.uade.ejb.dto;

import com.uade.ejb.entities.FotoEntity;

public class FotoDto {
	public int id;
	public String url;
    
    public static FotoDto fromEntity(FotoEntity entity) {
    	FotoDto dto = new FotoDto();
    	dto.url = entity.getUrl();
    	return dto;
    }
}
