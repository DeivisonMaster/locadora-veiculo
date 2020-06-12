package br.com.locadora.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.locadora.model.Aluguel;
import br.com.locadora.util.jpa.EntityManagerProducer;

public class AluguelDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
//	public AluguelDAO() {
//		this.entityManager = new EntityManagerProducer().create();
//	}
	
	public void salvar(Aluguel aluguel) {
		this.entityManager.merge(aluguel); // merge = resolve detached entity
	}

}
