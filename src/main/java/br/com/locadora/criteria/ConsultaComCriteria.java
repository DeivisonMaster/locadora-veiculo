package br.com.locadora.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.com.locadora.model.ModeloCarro;
import br.com.locadora.model.Usuario;

public class ConsultaComCriteria {
	private static EntityManager iniciaEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = factory.createEntityManager();
		return em;
	}
	
	public static void main(String[] args) {
		EntityManager em = iniciaEntityManager();
		
		consultaUsuarioPorNome(em);
		
		em.close();
	}

	private static void consultaUsuarioPorNome(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteria.from(Usuario.class);
		criteria.select(usuario);
		criteria.where(builder.like(usuario.get("nome"), "aux%"));
		
		List<Usuario> usuarios = em.createQuery(criteria).getResultList();
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	private static void consultaUsuarios(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> usuario = criteria.from(Usuario.class);
		criteria.select(usuario);
		
		List<Usuario> usuarios = em.createQuery(criteria).getResultList();
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
	
}



















