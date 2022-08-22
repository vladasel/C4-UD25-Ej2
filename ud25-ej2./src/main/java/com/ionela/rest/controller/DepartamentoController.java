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

import com.ionela.rest.dto.Departamento;
import com.ionela.rest.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	@Autowired
	DepartamentoServiceImpl departamentoServideImpl;

	@GetMapping("/departamentos")
	public List<Departamento> listarDepartamentos() {
		return departamentoServideImpl.listarDepartamentos();
	}

	@PostMapping("/departamentos")
	public Departamento salvarDepartamento(@RequestBody Departamento departamento) {

		return departamentoServideImpl.guardarDepartamento(departamento);
	}

	@GetMapping("/departamentos/{id}")
	public Departamento departamentoXID(@PathVariable(name = "id") Long id) {

		Departamento departamento_xid = new Departamento();

		departamento_xid = departamentoServideImpl.departamentoXID(id);

		System.out.println("Departamento XID: " + departamento_xid);

		return departamento_xid;
	}

	@PutMapping("/departamentos/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name = "id") Long id,
			@RequestBody Departamento departamento) {

		Departamento dep_seleccionado = new Departamento();
		Departamento dep_actualizado = new Departamento();

		dep_seleccionado = departamentoServideImpl.departamentoXID(id);

		dep_seleccionado.setNombre(departamento.getNombre());
		dep_seleccionado.setPresupuesto(departamento.getPresupuesto());

		dep_actualizado = departamentoServideImpl.actualizarDepartamento(dep_seleccionado);

		return dep_actualizado;
	}

	@DeleteMapping("/departamentos/{id}")

	public void eleiminarEmpleado(@PathVariable(name = "id") Long id) {
		departamentoServideImpl.eliminarDepartamento(id);
	}

}
