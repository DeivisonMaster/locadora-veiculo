package br.com.locadora.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.FuncionarioDAO;
import br.com.locadora.model.Funcionario;
import br.com.locadora.service.FuncionarioService;

@Named("consultaFuncionario")
@ViewScoped
public class ConsultaFuncionarioController implements Serializable{
	private static final long serialVersionUID = 1L;

	private Funcionario funcionarioSelecionado;
	private List<Funcionario> funcionarios;
	
	@Inject
	private FuncionarioService funcionarioCarroService;
	
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.funcionarios = funcionarioCarroService.buscarTodos();
	}
	
	public void limpar() {
		this.funcionarioSelecionado = new Funcionario();
	}
	
	public void excluir() {
		this.funcionarioCarroService.excluir(this.funcionarioSelecionado);
	}
	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
}
