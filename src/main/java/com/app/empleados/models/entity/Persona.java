package com.app.empleados.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class Persona implements Serializable{
	
	private static final long serialVersionUID = -5276417058563667536L;
	@Id
	@Column(length = 10)
	private String cedula;
	
	
	@NotBlank(message = "Nombres es un campo obligatorio")
	@Column(length = 100)
	private String nombres;
	@NotBlank(message = "Apellidos es un campo obligatorio")
	@Column(length = 100)
	private String apellidos;
	@Column(length = 100)
	private String correo;
	@Temporal(TemporalType.DATE)
	private Date fnacimiento;
	@Column(length = 100)
	private String direccion;
	@Column(length = 10)
	private String telefono;
	private int vacunado;
	
	/*private int vacunado;
	private String tipoVacuna;
	@Temporal(TemporalType.DATE)
	private Date fvacunacion;
	private int dosis;*/
	
	public Persona() {
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getFnacimiento() {
		return fnacimiento;
	}
	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/*public int isVacunado() {
		return vacunado;
	}
	public void setVacunado(int vacunado) {
		this.vacunado = vacunado;
	}
	public String getTipoVacuna() {
		return tipoVacuna;
	}
	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}
	public int getVacunado() {
		return vacunado;
	}

	public Date getFvacunacion() {
		return fvacunacion;
	}
	public void setFvacunacion(Date fvacunacion) {
		this.fvacunacion = fvacunacion;
	}
	public int getDosis() {
		return dosis;
	}
	public void setDosis(int dosis) {
		this.dosis = dosis;
	}
	*/

	public int getVacunado() {
		return vacunado;
	}

	public void setVacunado(int vacunado) {
		this.vacunado = vacunado;
	}

}
