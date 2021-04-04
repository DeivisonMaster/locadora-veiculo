package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Carro;


public class QuerieAgregada {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
//		String jpql = "select c, count(a), max(a.valorTotal), avg(a.valorTotal) from Carro c JOIN c.aluguel a GROUP BY c";
		String jpql = "select new jpql.AluguelCarroInfo(c, count(a), max(a.valorTotal), avg(a.valorTotal)) from Carro c join c.aluguel a group by c";
		List<AluguelCarroInfo> lista = em.createQuery(jpql, AluguelCarroInfo.class).getResultList();
		
		for (AluguelCarroInfo aluguel : lista) {
			System.out.println("Modelo: " + aluguel.getCarro().getModeloCarro().getDescricao());
			System.out.println("Quantidade: " + aluguel.getTotalAlugueis());
			System.out.println("Média: " + aluguel.getValorMedio());
			System.out.println("Valor total: " + aluguel.getValorMaximo());
		}
	}
}
