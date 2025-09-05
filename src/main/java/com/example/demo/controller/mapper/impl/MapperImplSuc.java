package com.example.demo.controller.mapper.impl;

import org.springframework.stereotype.Component;

import com.example.demo.controller.dto.request.DtoRequestSuc;
import com.example.demo.controller.dto.response.DtoResponseSuc;
import com.example.demo.controller.mapper.MapperSuc;
import com.example.demo.model.ModelSuc;
@Component
public class MapperImplSuc implements MapperSuc{

	@Override
	public ModelSuc DtoToModel(DtoRequestSuc dto) {
		if(dto==null)
			return null;
		ModelSuc model=new ModelSuc();
		model.setCiudad(dto.getCiudad());
		model.setName(dto.getName());
		model.setTelefono(dto.getTelefono());
		return model;
	}

	@Override
	public DtoResponseSuc ModelToDto(ModelSuc model) {
		if(model==null)
			return null;
		DtoResponseSuc dto=new DtoResponseSuc();
		dto.setId(model.getId());
		dto.setCiudad(model.getCiudad());
		dto.setName(model.getName());
		dto.setTelefono(model.getTelefono());
		return dto;
	}
}
