package com.app.empleados.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.empleados.common.ValidarCedula;
import com.app.empleados.models.entity.Persona;
import com.app.empleados.models.entity.Usuario;
import com.app.empleados.models.service.IPersonaService;
import com.app.empleados.models.service.IUsuarioService;


@RestController
public class PersonaController {
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/listar")
	public List<Persona> listar() {
		return personaService.findAll();
	}

	@GetMapping("/ver/{cedula}")
	public Persona detalle(@PathVariable String cedula) {
		return personaService.findById(cedula);
	}

	@PostMapping("/crearPersona")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona crear(@RequestBody Persona persona, HttpServletResponse response) throws IOException {
		ValidarCedula valCedula = new ValidarCedula();
		if (!valCedula.validarCedula(persona.getCedula())) {
			response.sendError(500, "Cedula invalida");
			return null;
		}
		
		return personaService.save(persona);
	}

	@PutMapping("/editarAdmin/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona editarAdmin(@RequestBody Persona persona, @PathVariable String cedula) {
		Persona personaDb = personaService.findById(cedula);
		personaDb.setNombres(persona.getNombres());
		personaDb.setApellidos(persona.getApellidos());
		personaDb.setCorreo(persona.getCorreo());
		return personaService.save(personaDb);
	}

	@PutMapping("/editarEmpleado/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona editarEmpleado(@RequestBody Persona persona, @PathVariable String cedula,
			HttpServletResponse response) throws IOException {
		Persona personaDb = personaService.findById(cedula);
		if (personaDb != null) {
			personaDb.setFnacimiento(persona.getFnacimiento());
			personaDb.setDireccion(persona.getDireccion());
			personaDb.setTelefono(persona.getTelefono());
			personaDb.setVacunado(persona.getVacunado());

			return personaService.save(personaDb);
		}
		return null;
	}

	@DeleteMapping("/eliminar/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable String cedula) {
		personaService.deleteById(cedula);
	}

	@GetMapping("/listarPorEstado/{estado}")
	public List<Persona> listarPorListado(@PathVariable int estado) {
		return personaService.findByVacunado(estado);
	}

	@GetMapping("/listarPorTipoVacuna/{tipoVacuna}")
	public List<Persona> listarPorTipoVacuna(@PathVariable String tipoVacuna) {
		return personaService.findByTipoVacuna(tipoVacuna);
	}

	@GetMapping("/listarPorFVacunacion")
	@ResponseBody
	public List<Persona> findByEntryDateGreaterThanAndContactTypeWith(
			@RequestParam(name = "fdesde", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fdesde,
			@RequestParam(name = "fhasta", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fhasta) {

		return personaService.findByFVacunacion(fdesde, fhasta);
	}

}
