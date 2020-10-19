package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Projecoes {
	public static void main(String[] args) {
		// 6.5 Trabalhando com Projeções
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql = "select mc.descricao, mc.catergoria from ModeloCarro mc";
		List<Object[]> listaArray = entityManager.createQuery(jpql).getResultList();
		
		for (int i = 0; i < listaArray.size(); i++) {
			for (Object[] obj : listaArray) {
				System.out.println(obj[i]);
			}
		}
	}
}
