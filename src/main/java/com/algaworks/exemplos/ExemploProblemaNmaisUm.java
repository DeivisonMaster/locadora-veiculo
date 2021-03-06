package com.algaworks.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Carro;


public class ExemploProblemaNmaisUm {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<Carro> query = entityManager.createQuery("FROM Carro c", Carro.class);
		List<Carro> lista = query.getResultList();
		
		for (Carro carro : lista) {
			System.out.println(carro.getPlaca());
		}
	}
}
