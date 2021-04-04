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
		EntityManager em = factory.createEntityManager();
		
		String fabricante = "Volkswagen";
		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :pModelo";
		
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		query.setParameter("pModelo", fabricante);
		
		List<String> lista = query.getResultList();
		lista.forEach(i -> System.out.println(i));
		
	}
}
