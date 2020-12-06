package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Component
public class informacionDesdeBD implements obtenerInfoDesdeBD{

	private List<Hospital> _hospitales=getHospitalesDesdeBD();
	public List<Hospital> _hospital=new ArrayList<Hospital>();

	
	//Metodo que OBTIENE los datos de la base de datos
	@Override
	public List<Hospital> getHospitalesDesdeBD() {
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(1,"Pedro May","Administración de Empresas","Medico","pedro@gmail.com","9831235432"),
						new Persona(23,"Tendor Yam","Química de Empresas","Medico","tendor@gmail.com","9831235432"),
						new Persona(14,"Eduardo May","Administración de Empresas","Medico","eduardo@gmail.com","9831235432"),
						new Covid(45,42,12,32,54,23)),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(21,"Albert May","Administración de Empresas","Medico","albert@gmail.com","9831235432"),
						new Persona(12,"Mario May","Química de Empresas","Medico","mario@gmail.com","9831235432"),
						new Persona(4,"MArcos May","Administración de Empresas","Medico","marcos@gmail.com","9831235432"),
						new Covid(1,42,12,32,54,23)),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(55,"Kiko May","Administración de Empresas","Medico","marcos@gmail.com","9831235432"),
						new Persona(323,"Manuel Tamay","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(31,"Carlos May","Química","Medico","pedro@gmail.com","9831235432"),
						new Covid(3,42,12,32,54,23)),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(432,"Marquitos Mendez","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(42,"Juan Marquez","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(46,"Jose Tun","Química","Medico","pedro@gmail.com","9831235432"),
						new Covid(6,42,12,32,54,23))
				); 
		
		for (int i = 0; i < hospitales.size(); i++) {
			hospitales.get(i).get_director().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_director().setCargo("Director");
			
			hospitales.get(i).get_subdirector().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_subdirector().setCargo("Subdirector");
			
			hospitales.get(i).get_administrador().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_administrador().setCargo("Administrador");
		}
		
		return hospitales;
	}

	//Metodo que MODIFICA los datos en la base de datos
	public void setHospital(List<Hospital> hospital) {
		this._hospitales.set(this.getIndexHospitalDeHospitales(hospital),hospital.get(0)); //se establece el hospital modificado dentro de los demas 
	}

	public Integer getIndexHospitalDeHospitales(List<Hospital> hospital) {
		for (int i = 0; i < this._hospitales.size(); i++) {
			if(this._hospitales.get(i).getId()==hospital.get(0).getId()) {
				return i;
			}
		}
		return null;
	}
	
	@Override
	public List<Hospital> getHospitalesActuales() {
		return this._hospitales;
	}
	
	public List<Hospital> getHospitalActual() {
		return this._hospital;
	}
	public void setHospitalActual(List<Hospital> _hospital) {
		this._hospital=_hospital;
	}

	public void vaciarHospitalActual() {
		this._hospital.clear();
	}

}
