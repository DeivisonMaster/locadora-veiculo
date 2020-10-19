package br.com.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import br.com.locadora.dao.AcessorioDAO;
import br.com.locadora.dao.CarroDAO;
import br.com.locadora.dao.ModeloCarroDAO;
import br.com.locadora.model.Acessorio;
import br.com.locadora.model.Carro;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.service.CadastroCarroService;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroCarro")
@ViewScoped
public class CadastroCarroController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Carro carro;
	private Collection<Acessorio> acessorios;
	private Collection<ModeloCarro> listaModeloCarro;
	private Acessorio[] acessoriosSelecionados;
	
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	@Inject
	private CadastroCarroService serviceCarro;
	
	private UploadedFile uploadFile;
	
	public CadastroCarroController() {
		this.carro = new Carro();
		this.acessorios = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		this.listaModeloCarro = this.modeloCarroDAO.buscarTodos();
		this.acessorios = this.acessorioDAO.buscarTodos();
	}
	
	public void salvar() {
		try {
			this.adicionaAcessorio();
			this.cadastraFotoDoVeiculo();
			
			this.serviceCarro.salvar(carro);
			FacesUtil.addSuccessMessage("Carro cadastrado com sucesso!");
			
			this.limpar();
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
			e.printStackTrace();
			
			this.limpar();
		}
	}
	
	public void cadastraFotoDoVeiculo() {
		if(this.uploadFile != null) {
			this.carro.setFoto(this.uploadFile.getContents());
		}
	}
	
	public void adicionaAcessorio() {
		for(Acessorio acessorio : acessoriosSelecionados) {
			this.carro.getAcessorios().add(acessorio);
		}
	}
	
	private void limpar() {
		this.carro = new Carro();
		this.acessoriosSelecionados = null;
	}

	public UploadedFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UploadedFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Collection<Acessorio> getAcessorios() {
		return acessorios;
	}
	public Collection<ModeloCarro> getListaModeloCarro() {
		return listaModeloCarro;
	}
	public Acessorio[] getAcessoriosSelecionados() {
		return acessoriosSelecionados;
	}
	public void setAcessoriosSelecionados(Acessorio[] acessoriosSelecionados) {
		this.acessoriosSelecionados = acessoriosSelecionados;
	}
	
}
