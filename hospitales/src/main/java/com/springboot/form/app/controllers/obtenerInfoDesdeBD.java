package com.springboot.form.app.controllers;

import java.util.List;

import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

public interface obtenerInfoDesdeBD {
	
	public List<Hospital> getHospitalesDesdeBD();
	public List<Hospital> getHospitalesActuales();
	public void setHospital(List<Hospital> hospital);
	public void setDirector(Persona persona);
	public void setSubdirector(Persona subdirector);
	public void setAdministrador(Persona administrador);

	public void setHospitalActual(List<Hospital> _hospital);
	public List<Hospital> getHospitalActual();
	public void vaciarHospitalActual();
	

	
}
