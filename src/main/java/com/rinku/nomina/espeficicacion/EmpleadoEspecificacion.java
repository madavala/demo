package com.rinku.nomina.espeficicacion;




import com.rinku.nomina.entidad.Empleado;
import com.rinku.nomina.entidad.Entrega;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;


public class EmpleadoEspecificacion {
	
    public static Specification<Empleado> empleadoPorNombre(String nombre) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.<String>get("nombre"), "%" + nombre + "%");
    }

    public static Specification<Empleado> empleadoConEntrega(Long idEmpleado) {
        return (root, query, criteriaBuilder) -> {
            Join<Entrega, Empleado> EntregasEmpleado = root.join("Entregas");
            return criteriaBuilder.equal(EntregasEmpleado.get("IdEmpleado"), idEmpleado);
        };
    }
    
    public static Specification<Empleado> entregaPorMes(int mes) {
        return (root, query, criteriaBuilder) -> {
            Join<Entrega, Empleado> EntregasEmpleado = root.join("Entregas");
            return criteriaBuilder.equal(EntregasEmpleado.get("mes"), mes);
        };
    }

}
