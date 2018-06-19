package com.uade.ejb.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OfertaHoteleraDto {
	public int id;
	public String nombre;
	public float precio;
	public int cupo;
	public String mediosDePago;
	public String tipoHabitacion;
	public EstablecimientoDto establecimiento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	public Date fechaDesde;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	public Date fechaHasta;	
	public String politicas;
	public String servicios;
}
