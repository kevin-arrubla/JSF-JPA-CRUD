package com.ecodeup.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;

@ManagedBean(name="clienteBean")


public class ClienteBean {

	public  List<Cliente> obtenerClientes() {
	ClienteDAO clienteDao= new ClienteDAO();
		return clienteDao.obtenerClientes();
		
	}
	
	public String nuevo() {
		
		Cliente c = new Cliente();
		
		Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/insertar.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDao=new ClienteDAO();
		clienteDao.guardar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String editar(Long id) {
	
		ClienteDAO clienteDao= new ClienteDAO();
		Cliente c = new Cliente();
		c=clienteDao.buscar(id);
		System.out.println(c);
		
		Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDao=new ClienteDAO();
		clienteDao.editar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String eliminar(Long id) {
		ClienteDAO clienteDao=new ClienteDAO();
		clienteDao.eliminar(id);
		
		return "/faces/index.xhtml";
	}
}
