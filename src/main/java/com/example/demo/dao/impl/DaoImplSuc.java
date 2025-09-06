package com.example.demo.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.jpa.Entity.EntitySuc;
import com.example.demo.dao.jpa.Entity.Entityciudad;
import com.example.demo.dao.jpa.Repository.RepositoryCiudad;
import com.example.demo.dao.jpa.Repository.RepositorySuc;
import com.example.demo.dao.DaoSuc;
import java.util.Optional;
import com.example.demo.model.ModelSuc;
@Service
public class DaoImplSuc implements DaoSuc{
	@Autowired
	private RepositorySuc repository;
	@Autowired
	private RepositoryCiudad repositoryCiudad;
	@Override
	public ModelSuc getSucursal(String id) {
	    Optional<EntitySuc> e = repository.findById(id);
	    ModelSuc model = new ModelSuc();

	    if (e.isPresent()) {
	        EntitySuc entity = e.get();
	        model.setId(entity.getId());
	        model.setName(entity.getName());
	        model.setTelefono(entity.getTelefono());
	        model.setCiudadNombre(entity.getCiudad().getNombre()); // creo que con est
	    }

	    return model;
	}

	@Override
	public ModelSuc postSucursal(ModelSuc model) {
	    // Buscar la ciudad por ID
	    Optional<Entityciudad> ciudadOpt = repositoryCiudad.findById(model.getCiudad());

	    if (ciudadOpt.isEmpty()) {
	        throw new RuntimeException("❌ La ciudad con id " + model.getCiudad() + " no existe");
	    }

	    EntitySuc entity = new EntitySuc();
	    entity.setCiudad(ciudadOpt.get()); // objeto completo
	    entity.setName(model.getName());
	    entity.setTelefono(model.getTelefono());

	    entity = repository.save(entity);

	    model.setId(entity.getId());
	    model.setCiudadNombre(entity.getCiudad().getNombre()); // ✅ setear el nombre

	    return model;
	}


	@Override
	public ModelSuc putSucursal(String id, ModelSuc model) {
		Optional<Entityciudad> ciudadOpt = repositoryCiudad.findById(model.getCiudad());

	    if (ciudadOpt.isEmpty()) {
	        throw new RuntimeException("❌ La ciudad con id " + model.getCiudad() + " no existe");
	    }
		Optional<EntitySuc>e=repository.findById(id);
		if(e.isPresent()) {
			EntitySuc entity=e.get();
			entity.setCiudad(ciudadOpt.get());
			entity.setName(model.getName());
			entity.setTelefono(model.getTelefono());
			repository.save(entity);
			System.out.println("Se realizo los cambios correspondiente");
		}
		return null;
	}

	@Override
	public ModelSuc deleteSucursal(String id) {
		Optional<EntitySuc>e=repository.findById(id);
		if(e.isPresent()) {
			EntitySuc entity=new EntitySuc();
			repository.deleteById(id);
			System.out.println("Se elimino el "+ id);
		}
		return null;
	}


	

}
