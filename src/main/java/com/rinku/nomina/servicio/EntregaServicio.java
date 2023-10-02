package com.rinku.nomina.servicio;

import java.util.List;

import com.rinku.nomina.entidad.Entrega;


public interface EntregaServicio{

	public List<Entrega> listarTodosLasEntregas();
	
	public Entrega guardarEntrega(Entrega entrega);
	
}
