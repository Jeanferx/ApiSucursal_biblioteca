package com.example.demo.service;

import com.example.demo.model.ModelSuc;

public interface ServiceSuc {
	ModelSuc getSucursal(String id);
	ModelSuc postSucursal(ModelSuc model);
	ModelSuc putSucursal(String id,ModelSuc model);
	ModelSuc deleteSucursal(String id);
	
}
