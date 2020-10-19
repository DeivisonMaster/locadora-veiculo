import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.locadora.model.Carro;
import br.com.locadora.model.Categoria;
import br.com.locadora.model.ModeloCarro;


public class Cascade {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		Carro carro = new Carro();
		carro.setCor("Preto");
		
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setCatergoria(Categoria.ESPORTIVO);
		carro.setModeloCarro(modeloCarro);
		
		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();
		
	}
}
