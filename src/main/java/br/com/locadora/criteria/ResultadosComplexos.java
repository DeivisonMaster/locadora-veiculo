package br.com.locadora.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.spi.ServiceException;

import br.com.locadora.model.Carro;
import br.com.locadora.util.NegocioException;

public class ResultadosComplexos {
	private static final Logger LOGGER = Logger.getLogger(ResultadosComplexos.class);
			
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
			em = factory.createEntityManager();
			
			resultadoComplexo(em);
			
		} catch (ServiceException e) {
			LOGGER.error("ERRO AO ABRIR CONEXÃO COM A BASE DE DADOS ", e);
		} catch (NegocioException e) {
			LOGGER.error(e);
		}
		
	}



	private static void resultadoTupla(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		Root<Carro> carro = criteria.from(Carro.class);
		
		criteria.multiselect(carro.get("placa").alias("placaCarro"), carro.get("valorDiaria").alias("valorCarro"));
		TypedQuery<Tuple> query = em.createQuery(criteria);
		
		List<Tuple> lista = query.getResultList();
		lista.forEach(t -> System.out.println(t.get("placaCarro") + " - " + t.get("valorCarro")));
	}
	
	

	private static void resultadoComplexo(EntityManager em) throws NegocioException {
		LOGGER.info("INICIANDO CONSULTA POR RESULTADO COMPLEXO");
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<Carro> carro = criteria.from(Carro.class);
		
		criteria.multiselect(carro.get("placa"), carro.get("valorDiaria"));
		
		TypedQuery<Object[]> query = em.createQuery(criteria);
		List<Object[]> lista = query.getResultList();
		
		lista.forEach(i -> System.out.println(i[0] + " - " + i[1]));
		
		LOGGER.error("ERRO AO EFETUAR CONSULTA");
		throw new NegocioException("ERRO AO EFETUAR CONSULTA");
	}
}
