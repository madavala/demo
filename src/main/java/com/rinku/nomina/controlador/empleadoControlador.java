package com.rinku.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rinku.nomina.entidad.Empleado;
import com.rinku.nomina.entidad.Entrega;
import com.rinku.nomina.servicio.EmpleadoServicio;
import com.rinku.nomina.servicio.EntregaServicio;

@Controller
public class empleadoControlador {
	
	@Autowired
	private EmpleadoServicio servicio;
	
	@Autowired
	private EntregaServicio servicio2;
	
	@GetMapping("/")
	public String mostrarEmpleados() {
		
		
		return "principal";
	}
	
	
	@GetMapping("/mostrarempleados")
	public String mostrarEmpleados(Model modelo) {
		
		modelo.addAttribute("empleados",servicio.listarTodosLosEmpleados());
		
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
		
		
		
		modelo.addAttribute("empleados",servicio.listarEmpleadosPorId(buscar));
		
		return "mostrarempleados";
	}
	
	@PostMapping("/empleado")
	public String guardarEmpleados(Empleado empleado) {
		
		servicio.guardarEmpleado(empleado);
		
		
		return "redirect:/mostrarempleados";
	}
	
	@GetMapping("/empleado/{id}")
	public String guardarEmpleados(@PathVariable Long id, Model modelo) {
		
		modelo.addAttribute("empleado",servicio.listarEmpleadosPorId(id));
		
		
		return "empleado";
	}
	
	@PostMapping("/entrega")
	public String registrarentrega(@RequestParam Long id,@RequestParam Integer mes, @RequestParam Integer cantidad) {
		
		Entrega entrega = new Entrega();
		entrega.setIdEmpleado(id);
		entrega.setMes(mes);
		entrega.setCantidad(cantidad);
		
		servicio2.guardarEntrega(entrega);
		
		return "redirect:/mostrarempleados";
	}
	
	@GetMapping("/entrega/{id}")
	public String entrega(@PathVariable Long id, Model modelo) {
		
		
		modelo.addAttribute("empleado",servicio.listarEmpleadosPorId(id));
		return "entrega";
	}


}
