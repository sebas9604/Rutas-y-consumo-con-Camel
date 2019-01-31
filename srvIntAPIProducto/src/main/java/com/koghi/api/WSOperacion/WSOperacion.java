package com.koghi.api.WSOperacion;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface WSOperacion {

	@POST
	@Path("/usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarUsuario(String user);
}
