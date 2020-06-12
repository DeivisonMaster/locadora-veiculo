package br.com.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.FabricanteDAO;
import br.com.locadora.model.Fabricante;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ConsultaFabricanteController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO dao;
	
	private Fabricante fabricanteSelecionado;
	private Collection<Fabricante> fabricantes;
	
	
	public ConsultaFabricanteController() {
		this.fabricanteSelecionado = new Fabricante();
		this.fabricantes = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		this.fabricantes = dao.buscarTodos();
	}
	
	public void excluir() {
		try {
			this.dao.excluir(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante excluído com sucesso!");
			
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
}
