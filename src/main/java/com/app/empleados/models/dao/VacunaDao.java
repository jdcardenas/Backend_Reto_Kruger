package com.app.empleados.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.empleados.models.entity.Vacuna;

@Repository
public interface VacunaDao extends CrudRepository<Vacuna, String>{

}
