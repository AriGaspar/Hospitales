package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.form.app.models.Administrador;

public interface IAdministradorRepo extends JpaRepository<Administrador, Integer>{
	
}
