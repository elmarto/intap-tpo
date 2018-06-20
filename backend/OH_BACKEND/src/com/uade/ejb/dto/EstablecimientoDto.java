package com.uade.ejb.dto;

import java.util.ArrayList;

import com.uade.ejb.entities.EstablecimientoEntity;

public class EstablecimientoDto {  
	public int id;
	public String nombre;
	public String direccion;
    public String uid;
    public ArrayList<FotoDto> fotosEstablecimiento;
    public CiudadDto ciudad;
    public HotelDto hotel;
	public MapaDto mapa;
    
    public static EstablecimientoDto fromEntity(EstablecimientoEntity entity) {
    	EstablecimientoDto dto = new EstablecimientoDto();
    	dto.direccion = entity.getDireccion();
    	dto.id = entity.getId();
    	dto.nombre = entity.getNombre();
    	dto.ciudad = entity.getCiudad().getDto();
    	dto.mapa = entity.getMapa().getDto();
    	entity.getFotosEstablecimiento().forEach((foto) -> dto.fotosEstablecimiento.add(foto.getDto()));
    	
    	dto.uid = entity.getUid();
    	if (entity.getHotel() != null) { 		
    		dto.hotel = entity.getHotel().getDto();
    	}
    	return dto;
    }
}
