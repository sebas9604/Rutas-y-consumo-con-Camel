package com.koghi.persistence.model;

public class Log {

	private String body;
	private String accion;
	private String descripcion;
	private String fecha;
	
	
	public Log(String body, String accion, String descripcion, String fecha) {
		this.body = body;
		this.accion = accion;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Log [body=" + body + ", accion=" + accion + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
	
	
}
