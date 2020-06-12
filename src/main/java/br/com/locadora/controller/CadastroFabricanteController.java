package br.com.locadora.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import br.com.locadora.model.Fabricante;
import br.com.locadora.service.CadastroFabricanteService;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
//@URLMappings(mappings = {
//		@URLMapping(id="fabricante", pattern = "/cadastro/fabricante", viewId = "/fabricante/CadastroFabricante.xhtml")
//})
public class CadastroFabricanteController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//private static final String LISTAR = "pretty:perfilConsultar";
	private Fabricante fabricante;
	
	@Inject
	private CadastroFabricanteService cadastroFabricanteService;
	
	public CadastroFabricanteController() {
		this.fabricante = new Fabricante();
	}

	@PostConstruct
	public void init() {
		limpar();
	}
	
	
	public void limpar() {
		this.fabricante = new Fabricante();
	}
	
	public void salvar() {
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
			
			this.limpar();
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
