package com.rinku.nomina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rinku.nomina.entidad.Empleado;
import com.rinku.nomina.entidad.Entrega;

@Repository
public interface EmpleadoRespositorio extends JpaRepository<Empleado,Long>, JpaSpecificationExecutor<Empleado> {

}
