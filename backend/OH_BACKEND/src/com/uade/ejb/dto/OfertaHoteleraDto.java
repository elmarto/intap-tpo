package com.uade.ejb.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OfertaHoteleraDto {
	public int id;
	public String nombre;
	public float precio;
	public int cupo;
	public String mediosDePago;
	public String tipoHabitacion;
	public EstablecimientoDto establecimiento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date fechaDesde;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date fechaHasta;	
	public String politicas;
	public String servicios;
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(this);
			return jsonInString;
		} catch (JsonProcessingException e) {
			System.out.println("Error converting oferta to JSON");
			e.printStackTrace();
			return "{}";
		}
	}
}
