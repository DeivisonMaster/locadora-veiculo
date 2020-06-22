package jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Fabricante;

public class ConsultaFabricantesPeloModeloCarro {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<String> query = entityManager.createQuery("select modeloCarro.fabricante.nome from ModeloCarro modeloCarro", String.class);
		List<String> lista = query.getResultList();
		
		for (String nome : lista) {
			System.out.println(nome);
		}
		
		entityManager.close();

	}
}
