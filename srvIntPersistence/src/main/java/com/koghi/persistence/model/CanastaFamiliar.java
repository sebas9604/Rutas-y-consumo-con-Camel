package com.koghi.persistence.model;

public class CanastaFamiliar {
	
	private String nombre;
	private String valor;
	private String descripcion;
	
	public CanastaFamiliar(String nombre, String valor, String descripcion) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "CanastaFamiliar [nombre=" + nombre + ", valor=" + valor + ", descripcion=" + descripcion + "]";
	}
	
	
}
