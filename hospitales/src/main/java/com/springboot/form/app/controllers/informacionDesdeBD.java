package com.springboot.form.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Hospital;

@Component
public class informacionDesdeBD implements obtenerInfoDesdeBD{

	//Metodo que OBTIENE los datos de la base de datos
	@Override
	public List<Hospital> getHospitales() {
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 1,4,2,3),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 3,4,2,6),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 3,6,2,7),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 2,8,1,7)
				);
		return hospitales;
	}
	
	//Metodo que MODIFICA los datos en la base de datos
	@Override
	public void setHospital() {
		
	}

}
