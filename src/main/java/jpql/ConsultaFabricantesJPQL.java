package jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Fabricante;


public class ConsultaFabricantesJPQL {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();

		TypedQuery<String> nomesFabricantes = entityManager.createQuery("select f.nome from Fabricante f", String.class);
		List<String> lista = nomesFabricantes.getResultList();
		
		System.out.println(lista);
		
		entityManager.close();
		
	}
}
