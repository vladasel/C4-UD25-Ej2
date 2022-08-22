package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Empleado;


public interface IEmpleadoService {
	//Metodos del CRUD
	public List<Empleado> listarEmpleados(); //Listar All 
	
	public Empleado guardarEmpleado(Empleado empleado);	//Guarda un empleado CREATE
	
	public Empleado empleadoXDNI(String dni); //Leer datos de un emplleado READ
	
	public Empleado actualizarEmpleado(Empleado empleado); //Actualiza datos del empleado UPDATE
	
	public void eliminarEmpleado(String dni);// Elimina el empleado DELETE
}
