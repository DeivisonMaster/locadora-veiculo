package br.com.locadora.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.DataValor;
import br.com.locadora.model.Usuario;
import br.com.locadora.util.jpa.EntityManagerProducer;

public class AluguelDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@Inject
	private EntityManager entityManager;
	
	public AluguelDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	public void salvar(Aluguel aluguel) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(aluguel); // merge = resolve detached entity
		this.entityManager.getTransaction().commit();
	}
	
	public Map<Date, BigDecimal> aluguelPorData(Integer numeroDias, Usuario usuario){
		Session session = entityManager.unwrap(Session.class);
		
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
		
		if(usuario != null) {
			criteria.add(Restrictions.eq("usuario", usuario.getNome()));
		}
		
		List<DataValor> valoresPorData = 
				criteria.setResultTransformer(Transformers.aliasToBean(DataValor.class)).list();
		
		for(DataValor dataValor : valoresPorData) {
			resultado.put(dataValor.getData(), dataValor.getValor());
		}
		
		return resultado;
	}
	
	private Map<Date, BigDecimal> criarMapaVazio(Integer numeroDias, Calendar dataInicial) {
		Map<Date, BigDecimal>  mapaInicial = new TreeMap<>();
		
		dataInicial = (Calendar) dataInicial.clone();
		
		for (int i = 0; i <= numeroDias; i++) {
			mapaInicial.put(dataInicial.getTime(), BigDecimal.ZERO);
			dataInicial.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return mapaInicial;
	}
	

}
