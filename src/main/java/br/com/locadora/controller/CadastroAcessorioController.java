package br.com.locadora.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.AcessorioDAO;
import br.com.locadora.model.Acessorio;
import br.com.locadora.service.CadastroAcessorioService;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroAcessorio")
@ViewScoped
public class CadastroAcessorioController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Acessorio acessorio;
	
	@Inject
	private CadastroAcessorioService serviceCadastro;
	
	public CadastroAcessorioController() {
		this.acessorio = new Acessorio();
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	
	public void salvar() {
		try {
			this.serviceCadastro.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório cadastrado com sucesso!");
			
			this.limpar();
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}


	private void limpar() {
		this.acessorio = new Acessorio();
	}
	
	public Acessorio getAcessorio() {
		return acessorio;
	}
	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
}
