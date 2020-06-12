//package com.algaworks.exemplos;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class ExemploTipoEmbutido {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		ProprietarioTabela2 prop = new ProprietarioTabela2();
//		prop.setNome("Maria");
//		prop.getTelefones().add(new Telefone("34", "1234-5678", "104"));
//		prop.getTelefones().add(new Telefone("56", "9898-9898", "365"));
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(prop);
//		entityManager.getTransaction().commit();
//		
//		ProprietarioTabela2 find = entityManager.find(ProprietarioTabela2.class, 1L);
//		
//		//System.out.println("Nome: " + find.getNome() + find.getTelefones());
//	}
//}
