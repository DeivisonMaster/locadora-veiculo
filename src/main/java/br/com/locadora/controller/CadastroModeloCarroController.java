package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.FabricanteDAO;
import br.com.locadora.model.Categoria;
import br.com.locadora.model.Fabricante;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.service.CadastroModeloCarroServico;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroModeloCarro")
@ViewScoped
public class CadastroModeloCarroController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ModeloCarro modeloCarro;
	private Collection<Fabricante> fabricantes;
	private Collection<Categoria> categorias;
	
	@Inject
	private CadastroModeloCarroServico cadastroModeloCarroService;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias  = Arrays.asList(Categoria.values());
	}
	
	
	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo de Carro salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}
	
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public Collection<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public Collection<Categoria> getCategorias() {
		return categorias;
	}
	
}
