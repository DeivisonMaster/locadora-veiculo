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

		TypedQuery<Fabricante> query1 = entityManager.createQuery("select f from Fabricante f", Fabricante.class);
		TypedQuery<String> query2 = entityManager.createQuery("select f.nome from Fabricante f", String.class);
		List<String> fabricantes = query2.getResultList();
		
		for (String fabricante : fabricantes) {
			System.out.println(fabricante);
		}
		
	}
}
