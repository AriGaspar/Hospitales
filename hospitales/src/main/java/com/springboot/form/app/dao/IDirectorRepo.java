package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.form.app.models.Director;

public interface IDirectorRepo extends JpaRepository<Director, Integer>{
	
}
