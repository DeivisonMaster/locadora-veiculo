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
//public class ExemploCachePrimeiroNivel {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		TypedQuery<Carro> query = entityManager.createQuery("from Carro c", Carro.class);
//		List<Carro> lista = query.getResultList();
//		
//		for (Carro carro : lista) {
//			System.out.println(carro.getId() + " = " + carro.getPlaca());
//		}
//		
//		entityManager.close();
//		
//		System.out.println("**************************************************");
//		
//		entityManager = factory.createEntityManager();
//		
//		Carro find = entityManager.find(Carro.class, 9L);
//		System.out.println(find.getId() + " = " + find.getPlaca());
//	}
//}
