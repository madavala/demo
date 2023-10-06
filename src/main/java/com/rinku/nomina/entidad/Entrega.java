package com.rinku.nomina.entidad;


	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "Entrega")
	public class Entrega {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@ManyToOne(optional = false)
	    @JoinColumn(name = "empleado_id")
		private Empleado empleado;
		
		@Column(name = "mes", nullable = false)
		private Integer mes;

		@Column(name = "cantidad", nullable = false)
		private Integer cantidad;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Empleado getEmpleado() {
			return empleado;
		}

		public void setEmpleado(Empleado empleado) {
			this.empleado = empleado;
		}

		public Integer getMes() {
			return mes;
		}

		public void setMes(Integer mes) {
			this.mes = mes;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		
		

	}



