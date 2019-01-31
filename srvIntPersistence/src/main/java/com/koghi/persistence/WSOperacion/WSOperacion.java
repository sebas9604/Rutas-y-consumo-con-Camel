package com.koghi.persistence.WSOperacion;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/")

public interface WSOperacion {
	@POST
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarUsuario(String user);
	
	@POST
	@Path("/crearUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearUsuario(String user);
	
	@POST
	@Path("/insertarProducto")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarProducto(String user);
	
	@POST
	@Path("/insertarServicio")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarServicio(String user);
	
	@POST
	@Path("/registrarError")
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarError(String user);
	
	@POST
	@Path("/registrarLog")
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarLog(String user);
}
