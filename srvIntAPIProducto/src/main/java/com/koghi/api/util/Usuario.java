package com.koghi.api.util;

public class Usuario {

	private String plan;
	private String tpID;
	private String nroId;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String correo1;
	private String correo2;
	private String fecha;
	
	public Usuario() {
		
	}
	public Usuario(String plan, String tpID, String nroId, String nombre1, String nombre2, String apellido1,
			String apellido2, String correo1, String correo2, String fecha) {
		this.plan = plan;
		this.tpID = tpID;
		this.nroId = nroId;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.fecha = fecha;
	}
	
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getTpID() {
		return tpID;
	}
	public void setTpID(String tpID) {
		this.tpID = tpID;
	}
	public String getNroId() {
		return nroId;
	}
	public void setNroId(String nroId) {
		this.nroId = nroId;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCorreo1() {
		return correo1;
	}
	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}
	public String getCorreo2() {
		return correo2;
	}
	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "{\"plan\": \"" + plan + "\", \"tpID\":\"" + tpID + "\", \"nroId\":\"" + nroId + "\", \"nombre1\":\"" + nombre1 + "\", \"nombre2\":\""
				+ nombre2 + "\", \"apellido1\":\"" + apellido1 + "\", \"apellido2\":\"" + apellido2 + "\", \"correo1\":\"" + correo1
				+ "\", \"correo2\":\"" + correo2 + "\", \"fecha\":\"" + fecha + "\"}";
	}
		
}
