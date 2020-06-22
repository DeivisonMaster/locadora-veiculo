package jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ConsultaModeloFiltrandoPorFabricante {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<String> query = entityManager.createQuery("select mc.fabricante.nome from ModeloCarro mc where mc.fabricante.nome = 'Volkswagen'", String.class);
		List<String> lista = query.getResultList();
		
		for (String s : lista) {
			System.out.println(s);
		}
	}
}
