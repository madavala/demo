package com.rinku.nomina.repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rinku.nomina.entidad.Entrega;

@Repository
public interface EntregaRepositorio extends JpaRepository<Entrega,Long>, JpaSpecificationExecutor<Entrega>{

	List<Entrega> findByMes(int mes);

	//Optional<Entrega> findByIdEmpleadoAndMes(Long empleado_id,Integer mes);
	
  // @Query(
  //          value = "select * FROM entrega ent, empleado emp WHERE ent.empleado_id=emp.id AND mes=?1 AND ent.empleado_id=?2",
  //          nativeQuery = true
  //      )
   Optional<Entrega> findByEmpleadoIdAndMes(Long empleado_id,Integer mes);

}
