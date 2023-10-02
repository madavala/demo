package com.rinku.nomina.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinku.nomina.entidad.Entrega;

import com.rinku.nomina.repositorio.EntregaRepositorio;

@Service
public class EntregaServicioImp implements  EntregaServicio {
	@Autowired
	private EntregaRepositorio repositorio;
	@Override
	public List<Entrega> listarTodosLasEntregas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Entrega guardarEntrega(Entrega entrega) {
		// TODO Auto-generated method stub
		
		repositorio.save(entrega);
		return entrega;
	}

}
