package com.rinku.nomina.servicio;

import java.util.List;


import com.rinku.nomina.entidad.Empleado;


public interface EmpleadoServicio  {
	
public List<Empleado> listarTodosLosEmpleados();

public Empleado guardarEmpleado(Empleado empleado);

Empleado listarEmpleadosPorId(Long id);

List<Empleado>  listarEmpleadosPorNombre(String Nombre);

List<Empleado>  listarEmpleadosPorRol(String Rol);


}
