package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelSuc {

	private String id;
	private String name;
	private Integer ciudad;
	private String telefono;
	private String ciudadNombre;
}
