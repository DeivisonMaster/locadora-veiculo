package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FiltrandoResultados {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<String> query = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Volkswagen' "
				+ "and mc.catergoria IN ('HATCH_COMPACTO', 'SEDAN_GRANDE')", String.class);
		List<String> modelos = query.getResultList();
		
		modelos.forEach(m -> System.out.println(m));

	}
}
