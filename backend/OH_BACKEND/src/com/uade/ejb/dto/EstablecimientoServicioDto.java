package com.uade.ejb.dto;

import java.util.Collection;

public class EstablecimientoServicioDto {
	public Collection<EstablecimientoDto> establecimientos;
	public Collection<ServicioDto> servicios;

	public EstablecimientoServicioDto(Collection<EstablecimientoDto> establecimientos, Collection<ServicioDto> servicios) {
		this.establecimientos = establecimientos;
		this.servicios = servicios;
	}
}
