package br.com.locadora.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Funcionario;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//@Inject
	private EntityManager entityManager;
	
	public FuncionarioDAO() {
		entityManager = new EntityManagerProducer().create();
	}

	
	public void salvar(Funcionario funcionario) {
		this.entityManager.merge(funcionario);
	}

	public List<Funcionario> buscarTodos() {
		TypedQuery<Funcionario> query = entityManager.createQuery("From Funcionario", Funcionario.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(Funcionario funcionarioSelecionado) {
		this.entityManager.remove(funcionarioSelecionado);
	}

	public Funcionario buscarPorId(Long id) {
		return this.entityManager.find(Funcionario.class, id);
	}
	
	

}
