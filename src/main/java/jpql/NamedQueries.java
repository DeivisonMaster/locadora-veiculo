package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.locadora.model.Acessorio;
import br.com.locadora.model.Carro;

public class NamedQueries {
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		List<Carro> lista1 = entityManager.createNamedQuery("Carro.buscarTodos", Carro.class).getResultList();
		List<Acessorio> lista2 = entityManager.createNamedQuery("Acessorio.buscarTodos", Acessorio.class).getResultList();
		
		for (Carro carro : lista1) {
			System.out.println(carro.getCor());
		}
		for (Acessorio a : lista2) {
			System.out.println(a.getDescricao());
		}
	}
}
