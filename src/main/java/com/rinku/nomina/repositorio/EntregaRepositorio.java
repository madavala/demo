package com.rinku.nomina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rinku.nomina.entidad.Entrega;

@Repository
public interface EntregaRepositorio extends JpaRepository<Entrega,Long>{

}
