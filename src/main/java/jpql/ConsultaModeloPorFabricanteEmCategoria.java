package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Categoria;
import br.com.locadora.model.Fabricante;
import br.com.locadora.model.ModeloCarro;

public class ConsultaModeloPorFabricanteEmCategoria {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<String> query = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Hyundai'", String.class);
		query.getResultList().forEach(nome -> System.out.println(nome));
		
	}
}
