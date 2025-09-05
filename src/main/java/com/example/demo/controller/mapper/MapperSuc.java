package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.request.DtoRequestSuc;
import com.example.demo.controller.dto.response.DtoResponseSuc;
import com.example.demo.model.ModelSuc;

public interface MapperSuc {
	ModelSuc DtoToModel(DtoRequestSuc dto);
	DtoResponseSuc ModelToDto(ModelSuc model);
}
