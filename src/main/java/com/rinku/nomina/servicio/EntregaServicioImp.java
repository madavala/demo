package com.rinku.nomina.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rinku.nomina.entidad.Entrega;
import com.rinku.nomina.repositorio.EntregaRepositorio;
import static com.rinku.nomina.espeficicacion.EmpleadoEspecificacion.*;

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
		Long idEmpleado = entrega.getEmpleado().getId();
		Integer mes = entrega.getMes();
		Integer anio= entrega.getAnio();
		
		Optional<Entrega> entregaOpcional = repositorio.findByEmpleadoIdAndMesAndAnio(idEmpleado,mes,anio);
        
		if(entregaOpcional.isPresent()) {

        	entrega.setId(entregaOpcional.get().getId());
		}else {
			entrega.setId(0);
		}
		repositorio.save(entrega);
		
		return entrega;
	}

	@Override
	public Entrega EntregaPorIdEmpleadoPorMes(Long id, int mes,int anio) {
		// TODO Auto-generated method stub
		Optional<Entrega> entregaOpcional = repositorio.findByEmpleadoIdAndMesAndAnio(id,mes,anio);
        if(entregaOpcional.isPresent()) {
			
			return entregaOpcional.get();
		}
        
		//Specification<Empleado> specification = empleadoConEntrega(id).and(entregaPorMes(mes));
		
		return null;
	}

	@Override
	public List<Entrega> listarEntregasPorMes(int mes, int anio) {
		// TODO Auto-generated method stub
		List<Entrega> entrega = repositorio.findByMesAndAnio(mes,anio);
		
		return entrega;
	}

	@Override
	public void borrarEntregaPorId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
