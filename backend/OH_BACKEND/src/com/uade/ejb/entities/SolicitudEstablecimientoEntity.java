package com.uade.ejb.entities;

public class SolicitudEstablecimientoEntity {
	public EstablecimientoEntity establecimiento;
	
	public SolicitudEstablecimientoEntity(EstablecimientoEntity establecimiento, int status)
	{
		this.establecimiento = establecimiento;
	}
	
	public void setEstablecimiento(EstablecimientoEntity establishment)
	{
		this.establecimiento = establishment;
	}
	
	public EstablecimientoEntity getEstablecimiento()
	{
		return this.establecimiento;
	}
}
