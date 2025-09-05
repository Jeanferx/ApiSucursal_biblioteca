package com.example.demo.dao.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.jpa.Entity.EntitySuc;


@Repository
public interface RepositorySuc extends JpaRepository<EntitySuc, String>{

}
