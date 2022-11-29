package com.app.empleados.models.service;

import java.util.Date;
import java.util.List;

import com.app.empleados.models.entity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	public Persona findById(String cedula);
	public List<Persona> findByVacunado(int estado);
	public List<Persona> findByTipoVacuna(String tipoVacuna);
	public List<Persona> findByFVacunacion(Date fdesde, Date fhasta);
	public Persona save(Persona producto);
	public void deleteById(String cedula);

}
