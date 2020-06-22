import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.DataAluguel;
import br.com.locadora.model.DataValor;
import br.com.locadora.security.Seguranca;
import br.com.locadora.util.jpa.EntityManagerProducer;

public class TesteConsultaRelatorio {
	
	public static void main(String[] args) {
		EntityManager em = new EntityManagerProducer().create();
		Session session = em.unwrap(Session.class);
		
		
		Map<Date, BigDecimal> aluguelPorData = aluguelPorData(15, session);
		for (Date data : aluguelPorData.keySet()) {
			System.out.println(data + " " + aluguelPorData.get(data));
		}
	}
	
	/*
	 * select date(data_criacao) as data, sum(valor_total) as valor 
	  	from pedido where data_criacao >= :dataInicial and vendedor_id = :criadoPor
		group by date(data_criacao)
	 * 
	 * */
	
	private static Map<Date, BigDecimal> aluguelPorData(Integer numeroDias, Session session){
		Calendar dataInicial = Calendar.getInstance();
		System.out.println(dataInicial);
		
		dataInicial	= DateUtils.truncate(dataInicial, Calendar.DAY_OF_MONTH);
		System.out.println(dataInicial);
		
		numeroDias -= 1;
		dataInicial.add(Calendar.DAY_OF_MONTH, numeroDias * -1); // recupera data retroativa (dia atual - dia parametro)
		
		Map<Date, BigDecimal> resultado = criarMapaVazio(numeroDias, dataInicial);
		
		Criteria criteria = session.createCriteria(Aluguel.class);
		
		criteria.setProjection(Projections.projectionList()
			.add(Projections.sqlGroupProjection(
					"date(data_cadastro) as data", " date(data_cadastro)", new String[] {"data"},
					new Type[] { StandardBasicTypes.DATE}))
				.add(Projections.sum("valorTotal").as("valor"))
			)
				.add(Restrictions.ge("dataCadastro", dataInicial.getTime())
			);
		
//		if(criadoPor != null) {
//			criteria.add(Restrictions.eq("vendedor", criadoPor));
//		}
		
		List<DataValor> valoresPorData = 
				criteria.setResultTransformer(Transformers.aliasToBean(DataValor.class)).list();
		
		for(DataValor dataValor : valoresPorData) {
			resultado.put(dataValor.getData(), dataValor.getValor());
		}
		
		return resultado;
	}
	
	private static Map<Date, BigDecimal> criarMapaVazio(Integer numeroDias, Calendar dataInicial) {
		Map<Date, BigDecimal>  mapaInicial = new TreeMap<>();
		
		dataInicial = (Calendar) dataInicial.clone();
		
		for (int i = 0; i <= numeroDias; i++) {
			mapaInicial.put(dataInicial.getTime(), BigDecimal.ZERO);
			dataInicial.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return mapaInicial;
	}
}
