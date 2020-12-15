package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid2;

public interface ICovidRepo extends JpaRepository<Covid2, Integer>{
	
}
