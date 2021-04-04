package jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import br.com.locadora.model.ApoliceSeguro;
import br.com.locadora.model.Fabricante;


public class ConsultaFabricantesJPQL {
	private static final Logger LOGGER = Logger.getLogger(ConsultaFabricantesJPQL.class);
			
	public static void main(String[] args) {
		try {
			EntityManager em = conecta();
			em.isOpen();
		} catch (ServidorIndisponivelException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
	}
	
	private static EntityManager conecta() {
		EntityManager em = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
			
			em = factory.createEntityManager();
		} catch (ServiceException e) {
			throw new ServidorIndisponivelException("PROBLEMA AO CONECTAR NO BANCO MYSQL ", e);
			
		} catch (NoResultException e) {
			LOGGER.error("NÃO HÁ RESULTADOS PARA A QUERY: ", e);
		}
		return em;
	}

	private static void consultaApoliceSeguro(EntityManager em) {
		TypedQuery<ApoliceSeguro> query = em.createQuery("from ApoliceSeguro", ApoliceSeguro.class);
		ApoliceSeguro apolice = query.getSingleResult();
		
		System.out.println(apolice);
	}
}
