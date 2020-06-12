//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class ExclusaoCascata {
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Carro carro = entityManager.find(Carro.class, 3L);
//		
//		entityManager.getTransaction().begin();
//		entityManager.remove(carro);
//		entityManager.getTransaction().commit();
//	}
//}
