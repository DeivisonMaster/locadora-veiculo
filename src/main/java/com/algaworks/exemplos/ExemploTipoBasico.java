//package com.algaworks.exemplos;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class ExemploTipoBasico {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		ProprietarioTabela1 prop = new ProprietarioTabela1();
//		prop.setNome("João");
//		prop.getTelefones().add("34 1234-7896");
//		prop.getTelefones().add("98 9998-8888");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(prop);
//		entityManager.getTransaction().commit();
//		
//		ProprietarioTabela1 find = entityManager.find(ProprietarioTabela1.class, 1L);
//		
//		//System.out.println("Nome: " + find.getNome() + find.getTelefones());
//	}
//}
