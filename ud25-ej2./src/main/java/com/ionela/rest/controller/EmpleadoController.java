package com.ionela.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionela.rest.dto.Empleado;
import com.ionela.rest.service.EmpleadoServiceImpl;
@RestController
@RequestMapping("/api")
public class EmpleadoController {
	@Autowired
	EmpleadoServiceImpl empleadoServideImpl;

	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServideImpl.listarEmpleados();
	}

	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {

		return empleadoServideImpl.guardarEmpleado(empleado);
	}

	@GetMapping("/empleados/{dni}")
	public Empleado empleadoXID(@PathVariable(name = "dni") String dni) {

		Empleado empleado_xid = new Empleado();

		empleado_xid = empleadoServideImpl.empleadoXDNI(dni);

		System.out.println("Empleado XID: " + empleado_xid);

		return empleado_xid;
	}

	@PutMapping("/empleados/{dni}")
	public Empleado actualizarEmpleado(@PathVariable(name = "dni") String dni, @RequestBody Empleado empleado) {

		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		empleado_seleccionado = empleadoServideImpl.empleadoXDNI(dni);

		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setDepartamento(empleado.getDepartamento());

		empleado_actualizado = empleadoServideImpl.actualizarEmpleado(empleado_seleccionado);

		return empleado_actualizado;
	}

	@DeleteMapping("/empleados/{dni}")
	public void eleiminarEmpleado(@PathVariable(name = "dni") String dni) {
		empleadoServideImpl.eliminarEmpleado(dni);
	}

}
