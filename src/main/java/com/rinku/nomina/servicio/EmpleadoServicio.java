package com.rinku.nomina.servicio;

import java.util.List;


import com.rinku.nomina.entidad.Empleado;


public interface EmpleadoServicio  {
	
public List<Empleado> listarTodosLosEmpleados();

public Empleado guardarEmpleado(Empleado empleado);

public Empleado listarEmpleadosPorId(Long id);

public List<Empleado>  listarEmpleadosPorNombre(String Nombre);

public List<Empleado>  listarEmpleadosPorRol(String Rol);

public int borrarEmpleadosPorId(Long id);

public List<Empleado> listarEntregasPorMes(int mes);


}
