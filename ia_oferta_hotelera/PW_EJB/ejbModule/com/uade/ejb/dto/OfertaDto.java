package com.uade.ejb.dto;

import java.sql.Date;

public class OfertaDto {
	public int id;
	public String nombre;
	public float precio;
	public int cupo;
	public String mediosDePago;
	public String tipoHabitacion;
	public EstablecimientoDto establecimiento;
	public Date fechaDesde;
	public Date fechaHasta;	
	public String politicas;
	public String servicios;
}
