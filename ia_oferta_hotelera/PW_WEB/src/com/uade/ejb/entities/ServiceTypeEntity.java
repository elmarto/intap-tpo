package com.uade.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "servicetype")
public class ServiceTypeEntity {
	@Column(name = "id_type_service")
	private int idServiceType;
	
	@Column(name = "name")
	private String name;
	
	
}
