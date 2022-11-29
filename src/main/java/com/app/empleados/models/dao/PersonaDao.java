package com.app.empleados.models.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.empleados.models.entity.Persona;

@Repository
public interface PersonaDao extends CrudRepository<Persona, String>{

	@Query ("Select p from Persona p where vacunado = :estado order by apellidos")
	List<Persona> findByVacunado(@Param("estado") int estado);
	
	@Query ("Select p from Persona p, Vacuna v "
			+ "where v.persona.cedula = p.cedula and v.tipoVacuna = :tipoVacuna order by v.tipoVacuna")
	List<Persona> findByTipoVacuna(@Param("tipoVacuna") String tipoVacuna);
	
	@Query ("Select p from Persona p, Vacuna v "
			+ "where v.persona.cedula = p.cedula and v.fvacunacion between :fdesde and :fhasta order by v.fvacunacion")
	List<Persona> findByFVacunacion(@Param("fdesde") Date fdesde, @Param("fhasta") Date fhasta);
}

