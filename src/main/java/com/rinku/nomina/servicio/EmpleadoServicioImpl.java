package com.rinku.nomina.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinku.nomina.entidad.Empleado;

import com.rinku.nomina.repositorio.EmpleadoRespositorio;
@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
	
	@Autowired
	private EmpleadoRespositorio repositorio;
	

	@Override
	public List<Empleado> listarTodosLosEmpleados() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}
	
	@Override
	public Empleado listarEmpleadosPorId(Long id) {
		// TODO Auto-generated method stub
		Empleado empleado = repositorio.findById(id).get();
		
		if (empleado==null)
		empleado = new Empleado();
		
		return empleado;
	}
	
	@Override
	public List<Empleado> listarEmpleadosPorNombre(String Nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
		repositorio.save(empleado);
		return empleado;
	}

	@Override
	public List<Empleado> listarEmpleadosPorRol(String Rol) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
