package com.rinku.nomina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rinku.nomina.entidad.Empleado;

@Repository
public interface EmpleadoRespositorio extends JpaRepository<Empleado,Long> {

}
