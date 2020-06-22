package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ConsultaAcessorioPorModeloCarro {
	public static void main(String[] args) {
		
		// 6.7 JOIN entre entidades
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql = "select a.descricao from Carro c join c.acessorios a where c.modeloCarro.descricao = 'Gol'";
		
		List<String> list = entityManager.createQuery(jpql, String.class).getResultList();
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
