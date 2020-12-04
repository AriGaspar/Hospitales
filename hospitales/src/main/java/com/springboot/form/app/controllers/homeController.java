package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Hospital;

@Controller
public class homeController {

	private obtenerInfoDesdeBD servicio;
	private List<Hospital> _hospitales;//Este es el hospital que se seleccione en los resultados
	private List<Hospital> _hospital = new ArrayList<>();//Este es el hospital que se seleccione en los resultados
	
	@Autowired
	public homeController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
		this._hospitales=servicio.getHospitales();
		
	}
	
	@PostMapping("/hospital")
	public String actualizarDatosHospitales(Hospital hospital, Model model) {
		List<Hospital> hospitalTemp = new ArrayList<>();
		hospital.setId(this._hospital.get(0).getId());
		hospitalTemp.add(hospital);
		
		setHospital(hospitalTemp);//Establece el hospital modificado dentro de la lista hospitales

		return "redirect:/hospitales";//Actualiza la pagina de todos los hospitales
	}

	@GetMapping("/hospital")
	public String apartadoInfoHospital(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		this._hospital.clear();//vaciar la lista porque solo debe de existir un elemento en la lista
		Stream<Hospital> hospitales = this._hospitales.stream()
				.filter(h -> h.getNombre().toLowerCase().equals(nombre.toLowerCase()));
		hospitales.forEach(h -> this._hospital.add(h));
		model.addAttribute("hospital", this._hospital);//
		return "apartado_hospital";
	}

	
	public void setHospital(List<Hospital> hospital) {
		this._hospital=hospital;
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
	public void addService(String servicio) {//Este metodo solo añade un servicio a la vez, pto spring >:(
//		int i=this.getIndexHospitalDeHospitales(this._hospital);//Obtiene index del hospital actual dentro de los hospitales
		String serviciosAnteriores=this._hospital.get(0).getServicios();
		this._hospital.get(0).setServicios(serviciosAnteriores.concat("-"+servicio));//Se establece el nuevo servicio dentro del hospital de la lista de hospitales
		
	}
}
