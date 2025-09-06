package com.example.demo.controller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class DtoRequestSuc {
	@NotEmpty
	@Size(max =50)
	private String name;
	@NotNull
	@Min(1)
	private Integer ciudad;

	@Size(max =50)
	private String telefono;
}
