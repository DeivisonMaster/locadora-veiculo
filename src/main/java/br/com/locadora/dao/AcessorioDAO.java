package br.com.locadora.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Acessorio;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class AcessorioDAO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EntityManager entityManager;
	
	public AcessorioDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	
	public void salvar(Acessorio acessorio) {
		this.entityManager.merge(acessorio); // merge = resolve detached entity
	}


	public Collection<Acessorio> buscarTodos() {
		TypedQuery<Acessorio> query = entityManager.createQuery("from Acessorio", Acessorio.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException{
		try {
			Acessorio acessorioId = this.buscarPorId(acessorio.getId()); // associa o objeto fabricante ao entityManager
			
			this.entityManager.remove(acessorioId);
			this.entityManager.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Erro ao excluir Carro");
		}
	}
	
	public Acessorio buscarPorId(Long id) {
		return this.entityManager.find(Acessorio.class, id);
	}
}
