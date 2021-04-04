package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Carro;

public class ConsultaComNamedQuery {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		
		TypedQuery<Carro> query = entityManager.createNamedQuery("consultaComAcessorio", Carro.class);
		query.setParameter("id", 1l);
		
		List<Carro> lista = query.getResultList();
		for (Carro carro : lista) {
			System.out.println(carro.getCor());
		}
	}
}
