package com.arrubla.ws.rest.dao;

import javax.persistence.EntityManager;

import com.arrubla.ws.rest.personaVO.JPAUtil;
import com.arrubla.ws.rest.personaVO.PersonaVo;


public class PersonaDao {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(PersonaVo miPersona) {
		
		entity.getTransaction().begin();
		entity.persist(miPersona);
		entity.getTransaction().commit();
		
	}
	
	public void editar(PersonaVo miPersona) {
		entity.getTransaction().begin();
		entity.merge(miPersona);
		entity.getTransaction().commit();
	}
	
	public void eliminar(int id) {
		
		PersonaVo cliente=new PersonaVo();
		cliente=entity.find(PersonaVo.class, id);
		entity.getTransaction().begin();
		entity.remove(cliente);
		entity.getTransaction().commit();
	}
}
