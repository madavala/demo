package com.rinku.nomina.servicio;

import java.util.List;

import com.rinku.nomina.entidad.Entrega;


public interface EntregaServicio{

	public List<Entrega> listarTodosLasEntregas();
	
	public Entrega guardarEntrega(Entrega entrega);
	
	public Entrega EntregaPorIdEmpleadoPorMes(Long idEmpleado, Integer mes);

	public List<Entrega> listarEntregasPorMes(int mes);
	
	public void borrarEntregaPorId(Long id);
	
}
