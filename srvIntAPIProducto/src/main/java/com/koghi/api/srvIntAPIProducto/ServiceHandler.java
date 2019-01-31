package com.koghi.api.srvIntAPIProducto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.koghi.api.util.OperacionesBase64;
import com.koghi.api.util.Usuario;

public class ServiceHandler {

	private Client client = ClientBuilder.newClient();
	private static final String END_POINT_CONSULTA_USUARIO = "http://192.168.4.94:9890/consultarUsuario";

	public void getUsuario(String usuario, Exchange ex) {
		System.out.println("SOUT: " + usuario);

		// Autenticacion
		String s = "";
		String aut = ex.getIn().getHeader("Authorization").toString();
		System.out.println(aut);
		String[] str = aut.split(" ");
		aut = str[1];
		OperacionesBase64 deco = new OperacionesBase64();
		s = deco.decodificar(aut);
		System.out.println("Auto decodificado: " + s);

		if (s.equals("koghi:K0Gh1")) {
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(usuario);

			// decodificar valores de entrada
			String tpid = "", nroid = "";
			tpid = deco.decodificar(jsonObject.get("TpId").getAsString());
			nroid = deco.decodificar(jsonObject.get("NroId").getAsString());
			ex.setOut(ex.getIn());

			String body = "{\"TpId\":\"" + tpid + "\",\"NroId\":\"" + nroid + "\"}";
			System.out.println("body:" + body);

			try {
				Response response = client.target(END_POINT_CONSULTA_USUARIO).request(MediaType.APPLICATION_JSON)
						.post(Entity.entity(body, MediaType.APPLICATION_JSON));

				String result = response.readEntity(String.class);

				JsonObject jsonResult = (JsonObject) jsonParser.parse(result);
				Usuario u = new Usuario();
				u.setPlan(deco.codificar(jsonResult.get("plan").getAsString()));
				u.setTpID(deco.codificar(jsonResult.get("tpID").getAsString()));
				u.setNroId(deco.codificar(jsonResult.get("nroId").getAsString()));
				u.setNombre1(deco.codificar(jsonResult.get("nombre1").getAsString()));
				u.setNombre2(deco.codificar(jsonResult.get("nombre2").getAsString()));
				u.setApellido1(deco.codificar(jsonResult.get("apellido1").getAsString()));
				u.setApellido2(deco.codificar(jsonResult.get("apellido2").getAsString()));
				u.setCorreo1(deco.codificar(jsonResult.get("correo1").getAsString()));
				u.setCorreo2(deco.codificar(jsonResult.get("correo2").getAsString()));
				u.setFecha(deco.codificar(jsonResult.get("fecha").getAsString()));
				ex.getOut().setBody(u.toString());
			} catch (Exception e) {

				ex.getOut().setBody("Se ha producido un error de conexion se envia peticion a la cola");
			}
		} else {
			ex.getOut().setBody("Usuario y/o contraseña incorrectos");
		}
	}
}
