package br.com.locadora.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Carro;
import br.com.locadora.model.Genero;
import br.com.locadora.model.Motorista;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class MotoristaDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public MotoristaDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	
	public void salvar(Motorista motorista) {
		this.entityManager.merge(motorista); // merge = resolve detached entity
	}


	public Collection<Motorista> buscarTodos() {
		TypedQuery<Motorista> query = entityManager.createQuery("select m from Motorista m", Motorista.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(Motorista motorista) throws NegocioException{
		try {
			Motorista motoristaId = this.buscarPorId(motorista.getId()); // associa o objeto fabricante ao entityManager
			
			this.entityManager.remove(motoristaId);
			this.entityManager.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Erro ao excluir Carro");
		}
	}


	public Motorista buscarPorId(Long id) {
		return this.entityManager.find(Motorista.class, id);
	}
	
}
