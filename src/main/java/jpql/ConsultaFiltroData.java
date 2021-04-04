package jpql;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

public class ConsultaFiltroData {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(2020, 1, 1, 7, 0);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.set(2021, 12, 31, 7, 0);
		
		TypedQuery<Long> query = em.createQuery("select count(a) from Aluguel a where a.dataDevolucao between :inicio and :fim ", Long.class);
		query.setParameter("inicio", dataInicio.getTime());
		query.setParameter("fim", dataFim.getTime());
		
		List<Long> resultado = query.getResultList();
		System.out.println(resultado);
	}
}
