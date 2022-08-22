package com.ionela.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ionela.rest.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, String>{

}
