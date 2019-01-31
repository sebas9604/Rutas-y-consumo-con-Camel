package com.koghi.persitence.srvIntPersistence;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.camel.Exchange;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.koghi.persistence.model.Usuario;


public class ServiceHandler {

	public void getUsuario(String usuario, Exchange ex) 
	{
		System.out.println(usuario);
		Usuario user = new Usuario();

		String json = usuario; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
			
		String query = "sqlComponent:CALL consultar_usuario('" + jo.get("TpId").getAsString() + "', '" + jo.get("NroId").getAsString() + "')";
		ex.getContext().createProducerTemplate().send(query, ex);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> usuarios = ex.getOut().getBody(List.class);
		if (!usuarios.isEmpty()){
			user.setTpID(jo.get("TpId").getAsString());
			user.setNroId(jo.get("NroId").getAsString());
			Map<String, Object> operacion = usuarios.get(0);
			if (operacion.get("Plan")!=null)
				user.setPlan(operacion.get("Plan").toString());
			if (operacion.get("TpId")!=null)
				user.setPlan(operacion.get("TpId").toString());
			if (operacion.get("NroId")!=null)
				user.setPlan(operacion.get("NroId").toString());
			if (operacion.get("Nombre1")!=null)
				user.setNombre1(operacion.get("Nombre1").toString());
			if (operacion.get("Nombre2")!=null)
				user.setNombre2(operacion.get("Nombre2").toString());
			if (operacion.get("Apellido1")!=null)
				user.setApellido1(operacion.get("Apellido1").toString());
			if (operacion.get("Apellido2")!=null)
				user.setApellido2(operacion.get("Apellido2").toString());
			if (operacion.get("Correo1")!=null)
				user.setCorreo1(operacion.get("Correo1").toString());
			if (operacion.get("Correo2")!=null)
				user.setCorreo2(operacion.get("Correo2").toString());
			if (operacion.get("fecha")!=null)
				user.setFecha(operacion.get("fecha").toString());
			}
		System.out.println("TO STRING " + user.toString());
		
		ex.getOut().setBody(user.toString());
	}
	
	public void putUsuario(String usuario, Exchange exchange)
	{	
		System.out.println(usuario);

		String json = usuario; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
		jo.get("TpId").getAsString();

		Random rand = new Random();

		int n = rand.nextInt(2);
		System.out.println("Random: " + n);
		if(n > 0) {
		String query = "sqlComponent:CALL crear_usuario('" + jo.get("Plan").getAsString() + "', '" + jo.get("TpId").getAsString() + "', '" + jo.get("NroId").getAsString() 
				+ "', '" + jo.get("Nombre1").getAsString() + "', '" + jo.get("Nombre2").getAsString() + "', '" + jo.get("Apellido1").getAsString()
				+ "', '" + jo.get("Apellido2").getAsString() + "', '" + jo.get("Correo1").getAsString() + "', '" + jo.get("Correo2").getAsString() + "')";
		System.out.println("\n" + query);
		
		exchange.getContext().createProducerTemplate().send(query, exchange);
		System.out.println("OK");
		

		exchange.getOut().setBody("<InsertarCliente xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-\r\n" + 
				"instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://tempuri.org/\">\r\n" + 
				"\r\n" + 
				"<numeroProceso>13514</numeroProceso>\r\n" + 
				"<codError>nada</codError>\r\n" + 
				"<DescripcionRetorno>Nada</DescripcionRetorno>\r\n" + 
				"<CodigoError>300</CodigoError>\r\n" + 
				"</InsertarCliente>");
		}else {
			exchange.getOut().setBody("<InsertarCliente xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-\r\n" + 
					"instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://tempuri.org/\">\r\n" + 
					"\r\n" + 
					"<numeroProceso>13514</numeroProceso>\r\n" + 
					"<codError>nada</codError>\r\n" + 
					"<DescripcionRetorno>Ocurrio un error inesperado en la operacion</DescripcionRetorno>\r\n" + 
					"<CodigoError>100</CodigoError>\r\n" + 
					"</InsertarCliente>");
		}
		
		
	}
	
	public void putCanastaFamiliar(String cf, Exchange exchange)
	{
		
		System.out.println(cf);

		String json = cf; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
		
		String query = "sqlComponent:CALL insertar_producto('" + jo.get("Nombre").getAsString() + "', '" + jo.get("Valor").getAsString() + "', '" + jo.get("Descripcion").getAsString() + "')";
		System.out.println("\n" + query);
		exchange.getContext().createProducerTemplate().send(query, exchange);
		System.out.println("OK");
		exchange.getOut().setBody("OK");

	}
	
	public void putService(String service, Exchange exchange)
	{
		
		System.out.println(service);

		String json = service; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
		
		String query = "sqlComponent:CALL insertar_servicio('" + jo.get("Nombre").getAsString() + "', '" + jo.get("Body").getAsString() + "', '" + jo.get("Accion").getAsString() + "')";
		System.out.println("\n" + query);
		exchange.getContext().createProducerTemplate().send(query, exchange);
		System.out.println("OK");
		exchange.getOut().setBody("OK");

	}
	
	public void putError(String error, Exchange exchange)
	{
		
		System.out.println(error);

		String json = error; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
		
		String query = "sqlComponent:CALL registrar_error('" + jo.get("Body").getAsString() + "', '" + jo.get("Descripcion").getAsString() + "')";
		System.out.println("\n" + query);
		exchange.getContext().createProducerTemplate().send(query, exchange);
		System.out.println("OK");
		exchange.getOut().setBody("OK");

	}
	
	public void putLog(String log, Exchange exchange)
	{		
		System.out.println(log);

		String json = log; 
		JsonParser jsonParser = new JsonParser(); 
		JsonObject jo = (JsonObject)jsonParser.parse(json); 
		
		String query = "sqlComponent:CALL registrar_log('" + jo.get("Body").getAsString() + "', '" + jo.get("Accion").getAsString() + "', '" + jo.get("Descripcion").getAsString() + "')";
		System.out.println("\n" + query);
		exchange.getContext().createProducerTemplate().send(query, exchange);
		System.out.println("OK");
		exchange.getOut().setBody("OK");

	}
}
