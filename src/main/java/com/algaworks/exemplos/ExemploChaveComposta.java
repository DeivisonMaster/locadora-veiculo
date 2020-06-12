//package com.algaworks.exemplos;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.algaworks.curso.jpa2.model.Fabricante;
//import com.algaworks.exemplos.Veiculo;
//import com.algaworks.exemplos.VeiculoId;
//
//public class ExemploChaveComposta {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Veiculo veiculo = new Veiculo();
//		veiculo.setId(new VeiculoId("ABC-1234", "Rio Claro"));
//		
//		Fabricante fabricante = new Fabricante();
//		fabricante.setNome("Chevrolet");
//		
//		veiculo.setFabricante(fabricante);
//		
//		entityManager.getTransaction().begin();
//		//entityManager.persist(veiculo);
//		entityManager.getTransaction().commit();
//		
//		Veiculo find = entityManager.find(Veiculo.class, new VeiculoId("ABC-12345", "Rio Claro"));
//		System.out.println(find.getFabricante().getNome());
//		
//	}
//}
