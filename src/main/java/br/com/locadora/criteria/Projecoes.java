package br.com.locadora.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.locadora.model.Carro;

public class Projecoes {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		// select c.cor from Carro c
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<String> criteria = builder.createQuery(String.class);
		Root<Carro> carro = criteria.from(Carro.class);
		
		criteria.select(carro.get("placa"));
		
		TypedQuery<String> query = em.createQuery(criteria);
		List<String> placas = query.getResultList();
		
		placas.forEach(p -> System.out.println(p));
	}
}
