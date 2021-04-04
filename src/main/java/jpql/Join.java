package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Join {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		/* select from carro_acessorio ca
		 * inner join carro c
		 * 	on ca.id_carro = c.id
		 * inner join acessorio a
		 *  on ca.id_acessorio = a.id
		 * inner join modelo_carro mc
		 * 	on c.id_modelo_carro = mc.id
		 * where mc.descricao LIKE '%Polo%'
		 */
		
		
		TypedQuery<String> query = em.createQuery("select a.descricao from Carro c join c.acessorios a where c.modeloCarro.descricao = '%Polo%'", String.class);
		query.getResultList().forEach(d -> System.out.println(d));
		
		em.close();
	}
}
