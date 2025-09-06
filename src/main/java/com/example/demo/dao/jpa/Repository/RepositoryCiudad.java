package com.example.demo.dao.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.jpa.Entity.Entityciudad;

@Repository
public interface RepositoryCiudad extends JpaRepository<Entityciudad, Integer>{

}
