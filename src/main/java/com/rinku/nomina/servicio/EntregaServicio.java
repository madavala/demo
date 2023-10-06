package com.rinku.nomina.servicio;

import java.util.List;

import com.rinku.nomina.entidad.Entrega;


public interface EntregaServicio{

	public List<Entrega> listarTodosLasEntregas();
	
	public Entrega guardarEntrega(Entrega entrega);
	
	public Entrega EntregaPorIdEmpleadoPorMes(Long idEmpleado, int mes,int anio);

	public List<Entrega> listarEntregasPorMes(int mes,int anio);
	
	public void borrarEntregaPorId(Long id);
	
}
