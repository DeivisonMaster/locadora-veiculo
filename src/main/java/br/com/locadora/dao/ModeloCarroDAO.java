package br.com.locadora.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Fabricante;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public ModeloCarroDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		this.entityManager.merge(modeloCarro); // merge = resolve detached entity
	}


	public Collection<ModeloCarro> buscarTodos() {
		TypedQuery<ModeloCarro> query = entityManager.createQuery("from ModeloCarro", ModeloCarro.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException{
		ModeloCarro modeloCarroPorId = this.buscarPorId(modeloCarro.getId()); // associa o objeto fabricante ao entityManager
		
		try {
			this.entityManager.remove(modeloCarroPorId);
			this.entityManager.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Este modelo não pode ser excluido");
		}
		
	}
	
	public ModeloCarro buscarPorId(Long id) {
		return this.entityManager.find(ModeloCarro.class, id);
	}

	public List<ModeloCarro> buscarComPaginacao(int first, int pageSize) {
		TypedQuery<ModeloCarro> query = this.entityManager.createQuery("from ModeloCarro", ModeloCarro.class);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		List<ModeloCarro> lista = query.getResultList();
		
		return lista;
	}

	public Long encontrarQuantidadeDeModeloCarro() {
		return this.entityManager.createQuery("select count(mc) from ModeloCarro mc", Long.class)
				.getSingleResult();
	}
	
}	
