package br.com.locadora.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.locadora.model.Carro;

public class Funcoes {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Carro> criteria = builder.createQuery(Carro.class);
		Root<Carro> carro = criteria.from(Carro.class);
	
		Predicate andCor = builder.equal(builder.upper(carro.get("cor")), "branco".toUpperCase());
		
		criteria.select(carro);
		criteria.where(andCor);
		
		List<Carro> carros = em.createQuery(criteria).getResultList();
		
		carros.forEach(c -> System.out.println(c.getPlaca()));
		
	}
}
