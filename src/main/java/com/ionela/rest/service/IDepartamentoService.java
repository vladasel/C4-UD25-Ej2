package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Departamento;


public interface IDepartamentoService {

	//Metodos del CRUD
	public List<Departamento> listarDepartamentos(); //Listar All 
	
	public Departamento guardarDepartamento(Departamento departamento);	//Guarda un departamento CREATE
	
	public Departamento departamentoXID(Long id); //Leer datos de un departamento READ
	
	public Departamento actualizarDepartamento(Departamento departamento); //Actualiza datos del departamento UPDATE
	
	public void eliminarDepartamento(Long id);// Elimina el departamento DELETE
}
