package com.app.empleados.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.empleados.models.entity.Usuario;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
