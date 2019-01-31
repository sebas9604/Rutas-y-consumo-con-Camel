package com.koghi.persistence.model;

public class ErrorTransaccion {

	private String body;
	private String descripcion;
	private String feha;
	
	public ErrorTransaccion(String body, String descripcion, String feha) {
		this.body = body;
		this.descripcion = descripcion;
		this.feha = feha;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFeha() {
		return feha;
	}
	public void setFeha(String feha) {
		this.feha = feha;
	}
	
	@Override
	public String toString() {
		return "errorTransaccion [body=" + body + ", descripcion=" + descripcion + ", feha=" + feha + "]";
	}
	
	
}
