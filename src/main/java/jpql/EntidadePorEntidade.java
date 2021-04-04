package jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EntidadePorEntidade {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<String> query = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class);
		List<String> fabricantes = query.getResultList();
		fabricantes.forEach(f -> System.out.println(f));
		
		em.close();

	}
}
