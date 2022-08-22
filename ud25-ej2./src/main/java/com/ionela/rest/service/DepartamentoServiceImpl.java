package com.ionela.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ionela.rest.dao.IDepartamentoDAO;
import com.ionela.rest.dto.Departamento;

public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listarDepartamentos() {

		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento departamentoXID(Long id) {

		return iDepartamentoDAO.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		iDepartamentoDAO.deleteById(id);

	}

}
