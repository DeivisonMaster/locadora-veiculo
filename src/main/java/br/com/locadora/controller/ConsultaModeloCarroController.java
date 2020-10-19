
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.ModeloCarroDAO;
import br.com.locadora.lazy.model.LazyModeloCarroDataModel;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.service.CadastroModeloCarroServico;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;


@Named("consultaModeloCarro")
@ViewScoped
public class ConsultaModeloCarroController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroModeloCarroServico serviceModeloCarro;
	private Collection<ModeloCarro> listaModeloCarro;
	private ModeloCarro modeloCarroSelecionado;
	
	@Inject
	private ModeloCarroDAO modeloCarroDao;
	
	private LazyModeloCarroDataModel lazyModeloCarro;
	
	public ConsultaModeloCarroController() {
		this.modeloCarroSelecionado = new ModeloCarro();
	}
	
	
	@PostConstruct
	public void init() {
		this.lazyModeloCarro = new LazyModeloCarroDataModel(this.modeloCarroDao);
		//this.listaModeloCarro = serviceModeloCarro.buscarTodos();
	}
	
	public void excluir() {
		try {
			this.serviceModeloCarro.excluir(this.modeloCarroSelecionado);
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
	public LazyModeloCarroDataModel getLazyModeloCarro() {
		return lazyModeloCarro;
	}
	
	public Collection<ModeloCarro> getListaModeloCarro() {
		return listaModeloCarro;
	}
	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}
	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroSelecionado = modeloCarroSelecionado;
	}
}
