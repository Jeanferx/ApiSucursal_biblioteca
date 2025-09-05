package com.example.demo.dao;

import com.example.demo.model.ModelSuc;

public interface DaoSuc {
	ModelSuc getSucursal(String id);
	ModelSuc postSucursal(ModelSuc model);
	ModelSuc putSucursal(String id,ModelSuc model);
	ModelSuc deleteSucursal(String id);
}
