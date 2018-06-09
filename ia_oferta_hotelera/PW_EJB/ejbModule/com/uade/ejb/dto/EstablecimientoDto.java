package com.uade.ejb.dto;

import java.util.Collection;

import com.uade.ejb.entities.EstablishmentEntity;

public class EstablecimientoDto {  
	public int id;
	public String nombre;
	public String direccion;
    public String uid;
    public Collection<String> fotosEstablecimiento;
    
    public static EstablecimientoDto FromEntity(EstablishmentEntity entity) {
    	EstablecimientoDto dto = new EstablecimientoDto();
    	dto.direccion = entity.address;
    	dto.id = entity.id;
    	dto.nombre = entity.getName();
    	dto.uid = entity.getUid();
    	return dto;
    }
}
