package com.springboot.form.app.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Controller
public class editController {

	private obtenerInfoDesdeBD servicio;

	
	
	@Autowired
	public editController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
	}
	
	@PostMapping("/hospital")
	public String actualizarDatosHospitales(Hospital hospital , Model model) {
//		System.out.println("nose: "+hospital.getNombre());
		List<Hospital> hospitalTemp = new ArrayList<>();
		
		hospital.setId(servicio.getHospitalActual().get(0).getId());
		hospitalTemp.add(hospital);
		
		servicio.setHospital(hospitalTemp);//Establece el hospital modificado dentro de la lista hospitales

		return "redirect:/lista-hospitales";//Actualiza la pagina de todos los hospitales
	}
	@PostMapping("/personal")//String _nombre,String _titulo,String _profesion,String _email,String _telefono
	public String actualizarDatosPersonal(@ModelAttribute Persona persona , Model model) {
		System.out.println("asdasd: "+ persona.getCodigo());
//		servicio.getHospitalActual().get(0).set
		
		switch(persona.getCargo()) {
		case "Director":
			servicio.getHospitalActual().get(0).set_director(persona);
			break;
		case "Subdirector":
			servicio.getHospitalActual().get(0).set_subdirector(persona);
			break;
		case "Administrador":
			servicio.getHospitalActual().get(0).set_administrador(persona);
			break;
		}
		
		return "redirect:/lista-personal";//Actualiza la pagina de todos los hospitales
	}

	@PostMapping("/covid")
	public String actualizarDatosCovid(@ModelAttribute Covid covid , Model model) {
		System.out.println("asdasd: "+ covid.getId());
		servicio.getHospitalActual().get(0).set_covid(covid);
		
		return "redirect:/lista-covid";//Actualiza la pagina de todos los hospitales
	}
	
	@GetMapping("/covid")
	public String editarCovid(@RequestParam(value = "id", required = true) Integer id, Model model) {
		servicio.vaciarHospitalActual();
		List<Hospital> hospitalTemp = new ArrayList<>();
		Stream<Hospital> hospitales = this.servicio.getHospitalesActuales().stream()
				.filter(h -> h.get_covid().getId()==id);
		hospitales.forEach(h -> hospitalTemp.add(h));
		servicio.setHospitalActual(hospitalTemp);
		model.addAttribute("covid", hospitalTemp.get(0).get_covid());//
		return "editar-covid";
	}
	
	@GetMapping("/personal")
	public String editarPersona(@RequestParam(value = "id", required = true) int id, Model model) {
		
		model.addAttribute("persona", getPersonaActual(id).get(0));//
		return "editar-personal";
	}
	
	
	@GetMapping("/hospital")
	public String editarHospital(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		servicio.vaciarHospitalActual();
		List<Hospital> hospitalTemp = new ArrayList<>();
		Stream<Hospital> hospitales = this.servicio.getHospitalesActuales().stream()
				.filter(h -> h.getNombre().toLowerCase().equals(nombre.toLowerCase()));
		hospitales.forEach(h -> hospitalTemp.add(h));
		servicio.setHospitalActual(hospitalTemp);
		model.addAttribute("hospital", hospitalTemp);//
		return "editar-hospital";
	}
	
	private List<Persona> getPersonaActual(Integer id){
		servicio.vaciarHospitalActual();
		List<Hospital> hospitalTemp = new ArrayList<>();
		List<Persona> personaTemp = new ArrayList<>();
		Stream<Hospital> hospitales = this.servicio.getHospitalesActuales().stream()
				.filter(h -> h.get_director().getCodigo() == id ||
							 h.get_subdirector().getCodigo() == id ||
							 h.get_administrador().getCodigo() == id );
		
		hospitales.forEach(h -> {
			hospitalTemp.add(h);
			if(h.get_director().getCodigo() == id) {
				personaTemp.add(h.get_director());
			}else if(h.get_subdirector().getCodigo() == id) {
				personaTemp.add(h.get_subdirector());
			}else if(h.get_administrador().getCodigo() == id) {
				personaTemp.add(h.get_administrador());
			}
		});
		servicio.setHospitalActual(hospitalTemp);
		return personaTemp;
	}
	
	

}
