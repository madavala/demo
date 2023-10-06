package com.rinku.nomina.entidad;

public class Nomina {
	
	private Empleado empleado;
	private float horas;
	private float pagoTotalEntregas;
	private float pagoTotalBonos;
	private double retenciones;
	private double vales;
	private double sueldoTotal;
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public float getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public float getPagoTotalEntregas() {
		return pagoTotalEntregas;
	}
	public void setPagoTotalEntregas(float pagoTotalEntregas) {
		this.pagoTotalEntregas = pagoTotalEntregas;
	}
	public float getPagoTotalBonos() {
		return pagoTotalBonos;
	}
	public void setPagoTotalBonos(float pagoTotalBonos) {
		this.pagoTotalBonos = pagoTotalBonos;
	}
	public double getRetenciones() {
		return retenciones;
	}
	public void setRetenciones(double retenciones) {
		this.retenciones = retenciones;
	}
	public double getVales() {
		return vales;
	}
	public void setVales(double vales) {
		this.vales = vales;
	}
	public double getSueldoTotal() {
		return sueldoTotal;
	}
	public void setSueldoTotal(double sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}
	
}
