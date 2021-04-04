package br.com.locadora.criteria;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.locadora.model.Aluguel;

public class FuncoesAgregacao {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
	
		// select sum(a.valorTotal) from Aluguel a
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> criteria = builder.createQuery(BigDecimal.class);
		Root<Aluguel> aluguel = criteria.from(Aluguel.class);
		
		criteria.select(builder.max(aluguel.get("valorTotal")));
		TypedQuery<BigDecimal> query = em.createQuery(criteria);
		BigDecimal soma = query.getSingleResult();
		System.out.println(soma);
	}
}
