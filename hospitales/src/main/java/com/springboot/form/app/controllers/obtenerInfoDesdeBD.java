package com.springboot.form.app.controllers;

import java.util.List;

import com.springboot.form.app.models.Hospital;

public interface obtenerInfoDesdeBD {

	public List<Hospital> getHospitalesDesdeBD();
	public List<Hospital> getHospitalesActuales();
	public void setHospital(List<Hospital> hospital);
	
	
}
