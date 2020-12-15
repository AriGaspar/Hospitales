package com.springboot.form.app.models;

public class CasosCovid {

	private String casosNeg;
	private String casosEstudio;
	private String casosPositi;
	private String Recuperados;
	private String Defunciones;
	
	public String getCasosNeg() {
		return casosNeg;
	}
	public void setCasosNeg(String casosNeg) {
		this.casosNeg = casosNeg;
	}
	public String getCasosEstudio() {
		return casosEstudio;
	}
	public void setCasosEstudio(String casosEstudio) {
		this.casosEstudio = casosEstudio;
	}
	public String getCasosPositi() {
		return casosPositi;
	}
	public void setCasosPositi(String casosPositi) {
		this.casosPositi = casosPositi;
	}
	public String getRecuperados() {
		return Recuperados;
	}
	public void setRecuperados(String recuperados) {
		Recuperados = recuperados;
	}
	public String getDefunciones() {
		return Defunciones;
	}
	public void setDefunciones(String defunciones) {
		Defunciones = defunciones;
	}

}