package com.app.empleados.models.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.empleados.models.dao.VacunaDao;
import com.app.empleados.models.entity.Vacuna;

@Service
public class VacunaServiceImpl implements IVacunaService{

	@Autowired
	private VacunaDao vacunaDao;

	@Override
	@Transactional
	public Vacuna save(Vacuna vacuna) {
		return vacunaDao.save(vacuna);
	}

	@Override
	public void deleteById(String cedula, int dosis) {
		// TODO Auto-generated method stub	
	}
}
