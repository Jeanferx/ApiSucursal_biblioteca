package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.request.DtoRequestSuc;
import com.example.demo.controller.dto.response.DtoResponseSuc;
import com.example.demo.controller.mapper.MapperSuc;
import com.example.demo.model.ModelSuc;
import com.example.demo.service.ServiceSuc;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Sucursal")
public class ControllerSuc {
	@Autowired
	private ServiceSuc service;
	@Autowired
	private MapperSuc mapper;
	@GetMapping("/{id}")
	public ModelSuc getSucursal(@PathVariable("id")String id) {
		return service.getSucursal(id);
	}
	@PostMapping
	public DtoResponseSuc postSucursal(@Valid @RequestBody DtoRequestSuc dto) {
		ModelSuc model=service.postSucursal(mapper.DtoToModel(dto));
		return mapper.ModelToDto(model);
	}
	@PutMapping("/{id}")
	public ModelSuc putSucursal(@PathVariable("id")String id, @RequestBody ModelSuc model) {
		return service.putSucursal(id, model);
	}
	@DeleteMapping("/{id}")
	public ModelSuc deleteSucursal(@PathVariable("id")String id) {
		return service.deleteSucursal(id);
	}
}
