package com.uade.ejb.dto;

import java.util.Collection;

import com.uade.ejb.entities.EstablecimientoEntity;

public class EstablecimientoDto {  
	public int id;
	public String nombre;
	public String direccion;
    public String uid;
    public Collection<String> fotosEstablecimiento;
    
    public static EstablecimientoDto FromEntity(EstablecimientoEntity entity) {
    	EstablecimientoDto dto = new EstablecimientoDto();
    	dto.direccion = entity.getDireccion();
    	dto.id = entity.getId();
    	dto.nombre = entity.getNombre();
    	dto.uid = entity.getUid();
    	return dto;
    }
}
