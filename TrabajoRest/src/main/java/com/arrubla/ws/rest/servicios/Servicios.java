package com.arrubla.ws.rest.servicios;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arrubla.ws.rest.dao.PersonaDao;
import com.arrubla.ws.rest.personaVO.PersonaVo;

@Path("/PruebaArrubla")

public class Servicios {
	
	@GET
	@Path("/probarFuncion")
	@Consumes( {MediaType.APPLICATION_JSON})
	@Produces( {MediaType.APPLICATION_JSON})
	public PersonaVo probarFuncion() {

		PersonaVo miPersona= new PersonaVo();
		miPersona.setNombre("kevin");
		miPersona.setEstado(true);
		return miPersona;
	}
	
	
	@POST
	@Path("/guardarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public PersonaVo guardarPersona(PersonaVo miPersona) {
		PersonaDao personaDao =new PersonaDao();
		personaDao.guardar(miPersona);
		miPersona.setEstado(true);
		return miPersona;
	}
	

	@PUT
	@Path("/editarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaVo buscarPersona(PersonaVo miPersona) {
		PersonaDao personaDao = new PersonaDao();
		personaDao.editar(miPersona);
		miPersona.setEstado(true);
		return miPersona;
	}
	
	@DELETE
	@Path("/eliminarUsuario/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarPersona(@PathParam("id") int id) {
		PersonaDao miPersona = new PersonaDao();
		miPersona.eliminar(id);
		
	}
	
	
	
}
