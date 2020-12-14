package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springboot.form.app.models.Hospital2;

public interface IHospital2Repo extends JpaRepository<Hospital2, Integer>{

}
