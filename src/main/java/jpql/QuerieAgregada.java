package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.locadora.model.Carro;


public class QuerieAgregada {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql = "select c, count(a), max(a.valorTotal), avg(a.valorTotal) from Carro c JOIN c.aluguel a GROUP BY c";
		
		List<Object[]> resultados = entityManager.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("Modelo: " + ((Carro) obj[0]).getModeloCarro().getDescricao());
			System.out.println("Quantidade de alugueis: " + obj[1]);
			System.out.println("Valor máximo: " + obj[2]);
			System.out.println("Valor médio: " + obj[3]);
		}
		
	}
}
