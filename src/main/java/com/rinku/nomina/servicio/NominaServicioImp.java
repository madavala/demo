package com.rinku.nomina.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinku.nomina.entidad.Entrega;
import com.rinku.nomina.entidad.Nomina;
import com.rinku.nomina.repositorio.EntregaRepositorio;

@Service
public class NominaServicioImp implements NominaServicio {
	@Autowired
	private EntregaRepositorio repositorio;

	@Override
	public List<Nomina> calculoNomina(int mes) {
		// TODO Auto-generated method stub
		List<Entrega> entregas = repositorio.findByMes(mes);
		List<Nomina> nomina = new ArrayList<Nomina>();
		for (Entrega ent : entregas) {

			nomina.add(calculoPorEmpleado(ent));

		}

		return nomina;
	}

	public Nomina calculoPorEmpleado(Entrega ent) 
	{
		/*
		 * ● Los trabajadores tienen un sueldo base de $30 pesos la hora, tienen una jornada laboral de 8 horas, 6 días por semana.
		 * ● Adicionalmente, se les paga $5.00 por cada entrega que hagan al cliente en el recorrido de su jornada  laboral. 
		 * ● Los choferes reciben $10.00 de bono por hora, los cargadores $5.00 de bono por hora y los auxiliares no reciben bonos. 
		 * ● Se retiene a todos los empleados un 9% de impuesto sobre la renta (ISR). Aquellos empleados que en su sueldo mensual sobrepasan los $10,000.00 se les debe retener un 3% adicional de ISR.
		 * ● Los empleados reciben un 4% sobre su sueldo mensual en vales de despensa.  Considerar 4 semanas trabajadas por mes.
		 */
		Nomina reg = new Nomina();
		reg.setEmpleado(ent.getEmpleado());
		int horasPorMes=8*6*4;
		reg.setHoras(horasPorMes);
		int PagoPorEntragas=5*ent.getCantidad();
		reg.setPagoTotalEntregas(PagoPorEntragas);
		int bonos_=0;
		if(ent.getEmpleado().getRol().equals("chofer")) bonos_=10*horasPorMes;
		if(ent.getEmpleado().getRol().equals("cargador")) bonos_=5*horasPorMes;
		reg.setPagoTotalBonos(bonos_);
		float sueldo_neto = 30*horasPorMes+PagoPorEntragas+bonos_;
		double retenciones = 0;
		if(sueldo_neto<10000.00)
		 retenciones = sueldo_neto*0.09;
		else
		 retenciones = sueldo_neto*0.11;
		
		reg.setRetenciones(retenciones);
		double vales = sueldo_neto*0.09;
		reg.setVales(vales);
		reg.setSueldoTotal(sueldo_neto-retenciones+vales);
		
		return reg;
	}
}
