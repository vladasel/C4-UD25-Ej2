package com.ionela.rest.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departamentos")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column
	private String nombre;
	@Column
	private int presupuesto;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Empleado> empleado;

	public Departamento(Long codigo, String nombre, int presupuesto) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;

	}

	public Departamento() {
	}

	public Departamento(String nombre, int presupuesto) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

}
