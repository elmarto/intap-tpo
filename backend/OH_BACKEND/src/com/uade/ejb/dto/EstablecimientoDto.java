package com.uade.ejb.dto;

import java.util.ArrayList;

import com.uade.ejb.entities.EstablecimientoEntity;

public class EstablecimientoDto {  
	public int id;
	public String nombre;
	public String direccion;
	public String descripcion;
    public String uid = "";
    public String fotosEstablecimiento;
    public CiudadDto ciudad;
    public HotelDto hotel;
	public MapaDto mapa;
	public int estrellas;
    
    public static EstablecimientoDto fromEntity(EstablecimientoEntity entity) {
    	EstablecimientoDto dto = new EstablecimientoDto();
    	dto.direccion = entity.getDireccion();
    	dto.id = entity.getId();
    	dto.estrellas = entity.getEstrellas();
    	dto.descripcion = entity.getDescripcion();
    	dto.nombre = entity.getNombre();
    	dto.ciudad = entity.getCiudad().getDto();
    	dto.mapa = entity.getMapa().getDto();
    	dto.fotosEstablecimiento = entity.getFotosEstablecimiento();
    	
    	dto.uid = entity.getUid();
    	if (entity.getHotel() != null) { 		
    		dto.hotel = entity.getHotel().getDto();
    	}
    	return dto;
    }
}
