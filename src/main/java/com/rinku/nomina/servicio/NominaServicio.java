package com.rinku.nomina.servicio;

import java.util.List;

import com.rinku.nomina.entidad.Nomina;

public interface NominaServicio {

	List<Nomina> calculoNomina  (int mes,int anio);

}
