//package com.algaworks.exemplos;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class ExemploProblemaNmaisUm {
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		TypedQuery<Carro> query = entityManager.createQuery("FROM Carro c INNER JOIN FETCH c.modeloCarro mc", Carro.class);
//		List<Carro> lista = query.getResultList();
//		
//		for (Carro carro : lista) {
//			System.out.println(carro.getPlaca());
//		}
//	}
//}
