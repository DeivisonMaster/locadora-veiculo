package br.com.locadora.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.locadora.dao.CarroDAO;
import br.com.locadora.model.Carro;
import br.com.locadora.util.ErroConstraintException;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class CadastroCarroService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO dao;
	
	@Transactional
	public void salvar(Carro carro) throws NegocioException{
		
		try {
			this.dao.salvar(carro);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar carro");
		}
	}

	public Collection<Carro> buscaTodos() {
		return this.dao.buscarTodos();
	}

	public void excluir(Carro carroSelecionado) throws NegocioException, ErroConstraintException {
		this.dao.excluir(carroSelecionado);
	}

}
