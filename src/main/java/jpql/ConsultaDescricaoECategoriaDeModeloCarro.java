package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ConsultaDescricaoECategoriaDeModeloCarro {
	public static void main(String[] args) {
		
		// 6.5 Trabalhando com Projeções
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql  = "select mc.descricao, mc.categoria from ModeloCarro mc";
		List<Object[]> resultados = entityManager.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("descrição: " + obj[0]);
			System.out.println("descrição: " + obj[1]);
		}
	}
}
