package com.app.empleados.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.empleados.dto.VacunaDto;
import com.app.empleados.models.entity.Persona;
import com.app.empleados.models.entity.Vacuna;
import com.app.empleados.models.service.IPersonaService;
import com.app.empleados.models.service.IVacunaService;

@RestController
public class VacunaController {
	
	@Autowired
	private IVacunaService vacunaService;
	@Autowired
	private IPersonaService personaService;
	
	@PostMapping("/crearVacuna")
	@ResponseStatus(HttpStatus.CREATED)
	public Vacuna crear(@RequestBody VacunaDto vacunaDto) throws IOException {
		Persona persona = personaService.findById(vacunaDto.getCedula());
		Vacuna vacuna = new Vacuna();
		vacuna.setDosis(vacunaDto.getDosis());
		vacuna.setFvacunacion(vacunaDto.getFvacunacion());
		vacuna.setPersona(persona);
		vacuna.setTipoVacuna(vacunaDto.getTipoVacuna());
		return vacunaService.save(vacuna);
	}
}
