package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.locadora.model.ModeloCarro;

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
		
		for (String descricao : lista) {
			System.out.println(descricao);
		}
		
	}
}
