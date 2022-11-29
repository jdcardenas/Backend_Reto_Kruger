package com.app.empleados.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.empleados.models.dao.PersonaDao;
import com.app.empleados.models.entity.Persona;


@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private PersonaDao personaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>)personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(String cedula) {
		return personaDao.findById(cedula).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(String cedula) {
		personaDao.deleteById(cedula);		
	}

	@Override
	@Transactional
	public List<Persona> findByVacunado(int estado) {
		return (List<Persona>)personaDao.findByVacunado(estado);
	}

	@Override
	@Transactional
	public List<Persona> findByTipoVacuna(String tipoVacuna) {
		return (List<Persona>)personaDao.findByTipoVacuna(tipoVacuna);
	}

	@Override
	@Transactional
	public List<Persona> findByFVacunacion(Date fdesde, Date fhasta) {
		return (List<Persona>)personaDao.findByFVacunacion(fdesde, fhasta);
	}

}
