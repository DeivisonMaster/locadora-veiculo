package br.com.locadora.criteria;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.com.locadora.model.Carro;

public class SubQueries {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Carro> criteria = builder.createQuery(Carro.class);
		Subquery<Double> subquery = criteria.subquery(Double.class);
		
		Root<Carro> carro = criteria.from(Carro.class);

		// select avg(c.valorDiaria) from Carro c
		Root<Carro> carroSub = subquery.from(Carro.class);
		subquery.select(builder.avg(carroSub.get("valorDiaria")));
		
		// select c from Carro c where c.valorDiaria >= (select avg(c.valorDiaria) from Carro c)
		criteria.select(carro);
		criteria.where(builder.greaterThanOrEqualTo(carro.get("valorDiaria"), subquery));
		
		List<Carro> carros = em.createQuery(criteria).getResultList();
		carros.forEach(c -> System.out.println(c.getPlaca()));
	}
}
