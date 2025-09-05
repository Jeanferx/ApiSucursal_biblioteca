package com.example.demo.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.jpa.Entity.EntitySuc;
import com.example.demo.dao.jpa.Repository.RepositorySuc;
import com.example.demo.dao.DaoSuc;
import java.util.Optional;
import com.example.demo.model.ModelSuc;
@Service
public class DaoImplSuc implements DaoSuc{
	@Autowired
	private RepositorySuc repository;
	@Override
	public ModelSuc getSucursal(String id) {
		Optional<EntitySuc>e=repository.findById(id);
		ModelSuc model=new ModelSuc();
		if(e.isPresent()) {
			model.setCiudad(e.get().getCiudad());
			model.setId(e.get().getId());
			model.setName(e.get().getName());
			model.setTelefono(e.get().getTelefono());
		}else {
			
		}
		return model;
	}

	@Override
	public ModelSuc postSucursal(ModelSuc model) {
		EntitySuc entity=new EntitySuc();
		entity.setCiudad(model.getCiudad());
		entity.setName(model.getName());
		entity.setTelefono(model.getTelefono());
		entity=repository.save(entity);
		model.setId(entity.getId());
		return model;
	}

	@Override
	public ModelSuc putSucursal(String id, ModelSuc model) {
		Optional<EntitySuc>e=repository.findById(id);
		if(e.isPresent()) {
			EntitySuc entity=e.get();
			entity.setCiudad(model.getCiudad());
			entity.setName(model.getName());
			entity.setTelefono(model.getTelefono());
			repository.save(entity);
		}
		return null;
	}

	@Override
	public ModelSuc deleteSucursal(String id) {
		Optional<EntitySuc>e=repository.findById(id);
		if(e.isPresent()) {
			EntitySuc entity=new EntitySuc();
			repository.deleteById(id);
		}
		return null;
	}


	

}
