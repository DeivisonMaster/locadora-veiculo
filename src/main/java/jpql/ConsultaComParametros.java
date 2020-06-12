package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ConsultaComParametros {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		String modelo = "Volkswagen";
		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :pModelo";
		
		List<String> lista = entityManager.createQuery(jpql, String.class)
				//.setParameter(1, modelo)
				.setParameter("pModelo", modelo)
				.getResultList();
		
		for (String s : lista) {
			System.out.println(s);
		} 
	}
}
