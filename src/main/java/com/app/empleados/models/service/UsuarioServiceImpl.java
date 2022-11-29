package com.app.empleados.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.empleados.models.dao.UsuarioDao;
import com.app.empleados.models.entity.Usuario;

@Service
public class UsuarioServiceImpl  implements IUsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}


}
