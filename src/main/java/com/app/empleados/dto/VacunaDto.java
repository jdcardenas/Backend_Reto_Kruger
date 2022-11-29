package com.app.empleados.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class VacunaDto {
	
	private int dosis;
	private Date fvacunacion;
	private String tipoVacuna;
	private String cedula;
	
	@NotEmpty(message = "Dosis es un campo requerido")
	public int getDosis() {
		return dosis;
	}
	public void setDosis(int dosis) {
		this.dosis = dosis;
	}
	public Date getFvacunacion() {
		return fvacunacion;
	}
	public void setFvacunacion(Date fvacunacion) {
		this.fvacunacion = fvacunacion;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTipoVacuna() {
		return tipoVacuna;
	}
	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

}
