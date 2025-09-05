package com.example.demo.dao.jpa.Entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="sucursal")
public class EntitySuc {
	@Id
	@UuidGenerator
	private String id;
	private String name;
	private String ciudad;
	private String telefono;
	
}
