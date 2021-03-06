package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.boot.json.GsonJsonParser;
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

	private String _termino;
	private boolean _isAdmin = true;
	private List<Hospital> _hospitales = getHospitales();//Este es el hospital que se seleccione en los resultados
	private List<Hospital> _hospital = new ArrayList<>();//Este es el hospital que se seleccione en los resultados
	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@PostMapping({ "/home", "/search", "/hospital{nombre}" })
	public String getTermino(String busqueda, Model model) {
		/* System.out.println("Lo que se busco es esto creo: "+busqueda); */
		// model.addAttribute("termino",busqueda);
		this._termino = busqueda;
		System.out.println("termino: " + this._termino);
		return "redirect:/search?busqueda=".concat(this._termino);
	}
	
	@PostMapping("/hospital")
	public String actualizarDatosHospitales(Hospital hospital, Model model) {
		List<Hospital> hospitalTemp = new ArrayList<>();
		hospital.setId(this._hospital.get(0).getId());
		System.out.println("Que onda, probando esta cosa popo alv asdasdasdasd: "+hospital.getServicios());
//		hospital.setServicios(this._hospital.get(0).getServicios());
		hospitalTemp.add(hospital);
		
		this.setHospitalDesdePaginaHospital(hospitalTemp);//Establece el hospital modificado dentro de la lista hospitales

		return "redirect:/hospital?nombre=".concat(this._hospital.get(0).getNombre());//Actualiza la pagina con el nombre del hospital
	}

	@ModelAttribute("termino")
	public String termino() {
		return this._termino;
	}

	@GetMapping("/search")
	public String search(@RequestParam(value = "busqueda", required = true) String busqueda, Model model) {
		Stream<Hospital> hospitales = this._hospitales.stream()
				.filter(h -> h.getNombre().toLowerCase().contains(busqueda.toLowerCase())
						|| h.getServicios().toLowerCase().contains(busqueda.toLowerCase()));
		List<Hospital> hospital = new ArrayList<>();
		hospitales.forEach(h -> hospital.add(h));
		model.addAttribute("hospitales", hospital);
		model.addAttribute("isAdmin", this._isAdmin);
		model.addAttribute("busqueda", busqueda);
		return "search";
	}

	@GetMapping("/hospital")
	public String apartadoInfoHospital(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		this._hospital.clear();//vaciar la lista porque solo debe de existir un elemento en la lista
		Stream<Hospital> hospitales = this._hospitales.stream()
				.filter(h -> h.getNombre().toLowerCase().equals(nombre.toLowerCase()));
		hospitales.forEach(h -> this._hospital.add(h));
		model.addAttribute("hospital", this._hospital);//
		model.addAttribute("isAdmin", this._isAdmin);
		return "apartado_hospital";
	}

	

	//Metodo que OBTIENE los datos de la base de datos
	public List<Hospital> getHospitales() {//Metodo con informacion de prueba
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia")
				);
		return hospitales;
	}
	
	//Metodo que MODIFICA los datos en la base de datos
	public void setHospitalDesdePaginaHospital(List<Hospital> hospital) {
//		System.out.println("ID del hospital: "+hospital.get(0).getId());
//			System.out.println("ASDASDASDA ID hospitales: "+this._hospitales.get(i).getId()+"\nID hospital: "+hospital.get(0).getId());
			
		
		
		this._hospital=hospital;
//		System.out.println("id: " +index);
		
//		System.out.println(this._hospital.get(0).toString());
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
