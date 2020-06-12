//package com.algaworks.exemplos;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class ExemploPropriedadeTransiente {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Veiculo veiculo = entityManager.find(Veiculo.class, new VeiculoId("ABC-1234", "Rio Claro"));
//		
//		System.out.println(veiculo.getDescricao());
//	}
//}
