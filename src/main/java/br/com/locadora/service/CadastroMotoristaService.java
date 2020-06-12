package br.com.locadora.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import br.com.locadora.dao.MotoristaDAO;
import br.com.locadora.model.Motorista;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class CadastroMotoristaService implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Inject
	private MotoristaDAO dao;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException{
		
		try {
			this.dao.salvar(motorista);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Motorista");
		}
	}

	public Collection<Motorista> buscaTodos() {
		return this.dao.buscarTodos();
	}
}
