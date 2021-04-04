package br.com.locadora.criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.locadora.controller.CadastroAluguelController;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Fabricante;
import br.com.locadora.model.ModeloCarro;

public class ConsultaComFiltros {
	private static final Log LOGGER = LogFactory.getLog(ConsultaComFiltros.class);
	
	public static void persiste() {
		Aluguel a = new Aluguel();
		a.setDataEntrega(new Date());
		
		Carro carro = new Carro();
		
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setDescricao("Polo GTS");
		
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("Volkwagen");
		
		modeloCarro.setFabricante(fabricante);
		
		carro.setModeloCarro(modeloCarro);
		a.setCarro(carro);
		
//		em.getTransaction().begin();
//		em.persist(fabricante);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.persist(carro);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		
		//consultaPorFiltros(em);
		
		// select a from Aluguel a where a.valorTotal = :valorTotal and a.carro.modeloCarro.fabricante.nome = :modelo
//		BigDecimal valorTotal = BigDecimal.valueOf(100,0);
//		String modeloCarro = "Volkswagen"; 
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setId(2L);
		modeloCarro.setDescricao("Polo GTS");
		Fabricante fabricante = new Fabricante();
		fabricante.setId(1L);
		modeloCarro.setFabricante(fabricante);
		
		//List<Aluguel> alugueis = pesquisa(em, valorTotal, modeloCarro);
		List<Aluguel> alugueis = buscarAluguelPorDataDeEntregaEModeloCarro(em, null, modeloCarro);
		alugueis.forEach(a -> System.out.println(a.getCarro().getModeloCarro().getFabricante().getNome()));
		
	}
	
	public static List<Aluguel> pesquisa(EntityManager em, BigDecimal valorTotal, ModeloCarro modelo){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Aluguel> criteria = builder.createQuery(Aluguel.class);
		Root<Aluguel> aluguel = criteria.from(Aluguel.class);
		criteria.select(aluguel);
		
		Predicate andValor = null;
		if(Objects.nonNull(valorTotal)) {
			andValor = builder.equal(aluguel.get("valorTotal"), valorTotal);
			builder.and(andValor);
		}
		
		Predicate andModelo = null;
		if(Objects.nonNull(modelo)) {
			andModelo = builder.equal(aluguel.get("carro").get("modeloCarro").get("fabricante").get("nome"), modelo);
			builder.and(andModelo);
		}
		
		if(Objects.nonNull(andValor) || Objects.nonNull(andModelo)) {
			Predicate condicoes = builder.and(andValor, andModelo);
			criteria.where(condicoes);
		}
		
		TypedQuery<Aluguel> query = em.createQuery(criteria);
		return query.getResultList();
	}

	private static List<Aluguel> buscarAluguelPorDataDeEntregaEModeloCarro(EntityManager em, Date dataEntrega, ModeloCarro modelo) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Aluguel> criteria = builder.createQuery(Aluguel.class);
		Root<Aluguel> aluguel = criteria.from(Aluguel.class);
		
		criteria.select(aluguel);
		
		List<Predicate> condicoes = new ArrayList<>();
		
		if(Objects.nonNull(dataEntrega)) {
			ParameterExpression<Date> dataEntregaInicial = builder.parameter(Date.class, "dataEntregaInicial");
			ParameterExpression<Date> dataEntregaFinal = builder.parameter(Date.class, "dataEntregaFinal");
			
			Predicate andDataEntrega = builder.between(aluguel.get("dataEntrega"), dataEntregaInicial, dataEntregaFinal);
			condicoes.add(andDataEntrega);
		}
		
		if(Objects.nonNull(modelo)) {
			ParameterExpression<ModeloCarro> modeloCarro = builder.parameter(ModeloCarro.class, "modeloCarro");
			
			Predicate andDataEntrega = builder.equal(aluguel.get("carro").get("modelo"), modeloCarro);
			condicoes.add(andDataEntrega);
		}
		
		TypedQuery<Aluguel> query = em.createQuery(criteria);
		
		if(Objects.nonNull(dataEntrega)) {
			Calendar dataInicial = Calendar.getInstance();
			dataInicial.setTime(dataEntrega);
			dataInicial.set(Calendar.HOUR_OF_DAY, 0);
			dataInicial.set(Calendar.MINUTE, 0);
			dataInicial.set(Calendar.SECOND, 0);
			
			Calendar dataFinal = Calendar.getInstance();
			dataFinal.setTime(dataEntrega);
			dataFinal.set(Calendar.HOUR_OF_DAY, 23);
			dataFinal.set(Calendar.MINUTE, 59);
			dataFinal.set(Calendar.SECOND, 59);
			
			query.setParameter("dataEntregaInicial", dataInicial);
			query.setParameter("dataEntregaFinal", dataFinal);
		}
		
		if(Objects.nonNull(modelo)) {
			query.setParameter("modeloCarro", modelo);
		}
		
		criteria.where(condicoes.toArray(new Predicate[0]));
		return query.getResultList();
	}
	
	private static void consultaPorFiltros(EntityManager em) {
		TypedQuery<Aluguel> query = 
				em.createQuery("select a from Aluguel a where a.carro.modeloCarro.descricao = :pModeloCarro and a.valorTotal = :pValorTotal", Aluguel.class);
		query.setParameter("pModeloCarro", "Polo GTS");
		query.setParameter("pValorTotal", BigDecimal.valueOf(100.0));
		
		List<Aluguel> alugueis = query.getResultList();
		alugueis.forEach(a -> System.out.println(a.getCarro().getModeloCarro().getFabricante().getNome()));
	}

}
