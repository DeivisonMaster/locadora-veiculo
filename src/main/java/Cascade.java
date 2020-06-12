//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.algaworks.curso.jpa2.model.Carro;
//import com.algaworks.curso.jpa2.model.Categoria;
//import com.algaworks.curso.jpa2.model.ModeloCarro;
//
//public class Cascade {
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Carro carro = new Carro();
//		carro.setCor("Preto");
//		
//		ModeloCarro modeloCarro = new ModeloCarro();
//		modeloCarro.setCategoria(Categoria.ESPORTIVO);
//		carro.setModeloCarro(modeloCarro);
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(carro);
//		entityManager.getTransaction().commit();
//		
//	}
//}
