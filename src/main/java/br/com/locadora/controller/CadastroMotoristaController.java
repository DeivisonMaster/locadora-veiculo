package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.model.Genero;
import br.com.locadora.model.Motorista;
import br.com.locadora.service.CadastroMotoristaService;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroMotorisa")
@ViewScoped
public class CadastroMotoristaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Motorista motorista;
	private Collection<Genero>  generos;
	
	@Inject
	private CadastroMotoristaService motoristaService;
	
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.generos = Arrays.asList(Genero.values());
	}
	
	public void salvar() {
		try {
			this.motoristaService.salvar(this.motorista);
			FacesUtil.addSuccessMessage("Motorista cadastrado com sucesso!");
			
			this.limpar();
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
			this.limpar();
		}
	}
	
	private void limpar() {
		this.motorista = new Motorista();
	}
	
	public Collection<Genero> getGeneros() {
		return generos;
	}

	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}
