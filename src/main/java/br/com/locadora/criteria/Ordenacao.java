package br.com.locadora.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import br.com.locadora.model.Carro;

public class Ordenacao {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Carro> criteria = builder.createQuery(Carro.class);
		Root<Carro> carro = criteria.from(Carro.class);
		
		criteria.select(carro);
		criteria.orderBy(builder.desc(carro.get("id")));
		
		List<Carro> carros = em.createQuery(criteria).getResultList();
		
		carros.forEach(c -> System.out.println(c.getPlaca()));
		
	}
}
