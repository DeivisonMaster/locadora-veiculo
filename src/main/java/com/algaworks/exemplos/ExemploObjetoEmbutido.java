//package com.algaworks.exemplos;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.algaworks.curso.jpa2.model.Fabricante;
//import com.algaworks.exemplos.Proprietario;
//import com.algaworks.exemplos.Veiculo;
//import com.algaworks.exemplos.VeiculoId;
//
//public class ExemploObjetoEmbutido {
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Veiculo veiculo = new Veiculo();
//		veiculo.setId(new VeiculoId("ABC-1111", "Rio Claro"));
//		
//		Proprietario proprietario = new Proprietario();
//		proprietario.setNome("Deivison");
//		proprietario.setEmail("deivison@gmail.com");
//		proprietario.setTelefone("65 9999-8888");
//		
//		veiculo.setProprietario(proprietario);
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(veiculo);
//		entityManager.getTransaction().commit();
//		
//	}
//}
