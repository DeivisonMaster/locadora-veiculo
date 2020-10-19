import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.locadora.model.Carro;


public class ExclusaoCascata {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		Carro carro = entityManager.find(Carro.class, 1L);
		
		entityManager.getTransaction().begin();
		entityManager.remove(carro);
		entityManager.getTransaction().commit();
	}
}
