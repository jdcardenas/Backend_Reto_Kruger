package com.app.empleados.models.service;

import com.app.empleados.models.entity.Vacuna;

public interface IVacunaService {
	public Vacuna save(Vacuna vacuna);
	public void deleteById(String cedula, int dosis);

}
