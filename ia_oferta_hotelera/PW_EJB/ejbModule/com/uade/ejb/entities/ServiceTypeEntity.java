package com.uade.ejb.entities;

@Table(name = "servicetype")
public class ServiceTypeEntity {
	@Column(name = "id_type_service")
	private int idServiceType;
	@Column(name = "name")
	private String name;
	
	
}
