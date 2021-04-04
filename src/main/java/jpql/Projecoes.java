package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Projecoes {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		String consulta = "select mc.descricao, mc.catergoria from ModeloCarro mc";
		List<Object[]> lista = em.createQuery(consulta).getResultList();
		
		lista.forEach(i -> System.out.println(i[0]));
		
		em.close();
	}
}
