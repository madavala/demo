package com.rinku.nomina.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rinku.nomina.entidad.BuscarEntregas;
import com.rinku.nomina.entidad.Empleado;
import com.rinku.nomina.entidad.Entrega;
import com.rinku.nomina.servicio.EmpleadoServicio;
import com.rinku.nomina.servicio.EntregaServicio;
import com.rinku.nomina.servicio.NominaServicio;

@Controller
public class empleadoControlador {
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@Autowired
	private EntregaServicio entregaServicio;
	
	@Autowired
	private NominaServicio nominaServicio;
	
	private LocalDate currentdate = LocalDate.now();
	
	@GetMapping("/")
	public String mostrarEmpleados() {
		
		
		return "principal";
	}
	
	
	@GetMapping("/mostrarempleados")
	public String mostrarEmpleados(Model modelo) {
		
		modelo.addAttribute("mes",currentdate.getMonthValue());
		modelo.addAttribute("empleados",empleadoServicio.listarTodosLosEmpleados());
		
		return "mostrarempleados";
	}
	
	@GetMapping("/empleado")
	public String crearEmpleados(Model modelo) {
		
		Empleado empleado = new Empleado();
		
		modelo.addAttribute("empleado",empleado);
		
		return "empleado";
	}
	
	@PostMapping("/buscarempleado")
	public String buscarempleado(Model modelo,@RequestParam Long buscar) {
		
		
		
		modelo.addAttribute("empleados",empleadoServicio.listarEmpleadosPorId(buscar));
		
		return "mostrarempleados";
	}
	
	@PostMapping("/empleado")
	public String guardarEmpleados(Empleado empleado) {
		
		empleadoServicio.guardarEmpleado(empleado);
		
		
		return "redirect:/mostrarempleados";
	}
	
	@GetMapping("/empleado/{id}")
	public String guardarEmpleados(@PathVariable Long id, Model modelo) {
		
		modelo.addAttribute("empleado",empleadoServicio.listarEmpleadosPorId(id));
		
		
		return "empleado";
	}
	
	@GetMapping("/borrarempleado/{id}")
	public String borrarEmpleado(@PathVariable Long id, Model modelo) {
		
		empleadoServicio.borrarEmpleadosPorId(id);
		
		
		return "empleado";
	}
	
	@PostMapping("/entrega")
	public String registrarentrega(Entrega entrega) {
		
		entregaServicio.guardarEntrega(entrega);
		
		return "redirect:/mostrarempleados";
	}
	
	@GetMapping("/entrega/{id}/{mes}")
	public String entrega(@PathVariable Long id,@PathVariable int mes, Model modelo) {
		
		Entrega entrega = entregaServicio.EntregaPorIdEmpleadoPorMes(id,mes);
		
		if(entrega==null) {
			
			entrega =new Entrega();
			entrega.setId(0);
			entrega.setCantidad(0);
			entrega.setMes(mes);
			entrega.setEmpleado(empleadoServicio.listarEmpleadosPorId(id));
		}
		
		modelo.addAttribute("entrega",entrega);
		
		
		return "entrega";
	}
	
	@GetMapping("/borrarentrega/{id}")
	public String borrarentrega(@PathVariable Long id, Model modelo) {
		
		 entregaServicio.borrarEntregaPorId(id);
		
		
		return "entrega";
	}
	
	@PostMapping("/nomina")
	public String mostrarNomina(BuscarEntregas mes, Model modelo) {		
	
		modelo.addAttribute("mesnomina",mes);
		modelo.addAttribute("nomina",nominaServicio.calculoNomina(mes.getMes()));
		
		return "nomina";
	}
	
	@GetMapping("/nomina")
	public String mostrarNomina_(Model modelo) {		
		int mes =currentdate.getMonthValue();
		BuscarEntregas mesnomina= new BuscarEntregas();
		mesnomina.setMes(currentdate.getMonthValue());
		
		modelo.addAttribute("mesnomina",mesnomina);
		modelo.addAttribute("nomina",nominaServicio.calculoNomina(mes));
		
		return "nomina";
	}
	
	@GetMapping("/reporteentregas")
	
	public String reporteentrega(Model modelo) {
		
		BuscarEntregas buscarEntregas = new BuscarEntregas();
		
		buscarEntregas.setMes(currentdate.getMonthValue());
		
		modelo.addAttribute("BuscarEntregas",buscarEntregas);
		
		modelo.addAttribute("entregas",entregaServicio.listarEntregasPorMes(10));

		
		return "reporteentregas";
	}
}
