package br.com.locadora.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Fabricante;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class FabricanteDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public FabricanteDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	@Transactional
	public void salvar(Fabricante fabricante) {
		this.entityManager.merge(fabricante); // merge = resolve detached entity
	}


	public Collection<Fabricante> buscarTodos() {
		TypedQuery<Fabricante> query = entityManager.createQuery("from Fabricante", Fabricante.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException{
		Fabricante fabricantePorId = this.buscarPorId(fabricante.getId()); // associa o objeto fabricante ao entityManager
		
		this.entityManager.remove(fabricantePorId);
		this.entityManager.flush();
	}
	
	public Fabricante buscarPorId(Long id) {
		return this.entityManager.find(Fabricante.class, id);
	}
	
	
}
