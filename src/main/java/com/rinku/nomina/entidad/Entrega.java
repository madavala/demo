package com.rinku.nomina.entidad;


	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "Entrega")
	public class Entrega {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@Column(name = "idEmpleado", nullable = false, length = 50)
		private Long idEmpleado;
		
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

		public Long getIdEmpleado() {
			return idEmpleado;
		}

		public void setIdEmpleado(Long idEmpleado) {
			this.idEmpleado = idEmpleado;
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



