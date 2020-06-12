//package com.algaworks.exemplos;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class ExemploConsultaNativa {
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Query query = entityManager.createNativeQuery("select * from Carro", Carro.class);
//		List<Carro> lista = query.getResultList();
//		
//		for (Carro carro : lista) {
//			System.out.println(carro.getPlaca());
//		}
//	}
//}
