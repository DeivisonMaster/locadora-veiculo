package br.com.locadora.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.locadora.dao.FuncionarioDAO;
import br.com.locadora.model.Funcionario;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class FuncionarioService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDAO dao;
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		try {
			
			this.dao.salvar(funcionario);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Motorista");
		}
	}

	public List<Funcionario> buscarTodos() {
		return this.dao.buscarTodos();
	}

	public void excluir(Funcionario funcionarioSelecionado) {
		this.dao.excluir(funcionarioSelecionado);
	}

}
