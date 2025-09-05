package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoSuc;
import com.example.demo.model.ModelSuc;
import com.example.demo.service.ServiceSuc;
@Service
public class ServiceImplSuc implements ServiceSuc{
	@Autowired
	private DaoSuc daosucursal;
	public ServiceImplSuc(DaoSuc daosucursal) {
		this.daosucursal=daosucursal;
	}
	@Override
	public ModelSuc getSucursal(String id) {
		return daosucursal.getSucursal(id);
	}

	@Override
	public ModelSuc postSucursal(ModelSuc model) {
		return daosucursal.postSucursal(model);
	}

	@Override
	public ModelSuc putSucursal(String id, ModelSuc model) {
		return daosucursal.putSucursal(id,model);
	}

	@Override
	public ModelSuc deleteSucursal(String id) {
		return daosucursal.deleteSucursal(id);
	}

}
