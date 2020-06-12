package br.com.locadora.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.model.Funcionario;
import br.com.locadora.service.FuncionarioService;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroFuncionario")
@ViewScoped
public class CadastroFuncionarioController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	
	@Inject
	private FuncionarioService funcionarioService;
	
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	private void limpar() {
		this.funcionario = new Funcionario();
	}
	
	public void salvar() {
		try {
			this.funcionarioService.salvar(this.funcionario);
			
			FacesUtil.addSuccessMessage("Funcionário cadastrado com sucesso!");
			
			this.limpar();
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
			this.limpar();
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
