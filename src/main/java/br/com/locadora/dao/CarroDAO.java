package br.com.locadora.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import br.com.locadora.model.Carro;
import br.com.locadora.util.ErroConstraintException;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class CarroDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EntityManager entityManager;
	
	public CarroDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	
	public void salvar(Carro carro) {
		this.entityManager.merge(carro); // merge = resolve detached entity
	}


	public Collection<Carro> buscarTodos() {
		TypedQuery<Carro> query = entityManager.createQuery("From Carro", Carro.class);
		
//		TypedQuery<Carro> query = entityManager.createQuery("SELECT c.id, c.placa, c.cor, c.valorDiaria, acessorio.descricao\r\n" + 
//				"FROM Carro AS c\r\n" + 
//				"LEFT JOIN carro_acessorio as carro_acessorio\r\n" + 
//				"	ON carro_acessorio.id_carro = c.id\r\n" + 
//				"LEFT JOIN Acessorio AS acessorio\r\n" + 
//				"	ON carro_acessorio.id_acessorio = acessorio.id", Carro.class);
		
		return query.getResultList();
	}

	@Transactional
	public void excluir(Carro carro) throws NegocioException, ErroConstraintException{
		try {
			Carro carroId = this.buscarPorId(carro.getId()); // associa o objeto fabricante ao entityManager
			
			this.entityManager.remove(carroId);
			this.entityManager.flush();
			
		} catch (Exception e) {
			throw new ErroConstraintException("Erro ao excluir carro, há uma restrição de aluguel no banco de dados!", e.getCause());
		}
	}
	
	public Carro buscarPorId(Long id) {
		return this.entityManager.find(Carro.class, id);
	}


	public Carro buscaCarroComAcessorio(Long id) {
		TypedQuery<Carro> query = entityManager.createQuery("SELECT c FROM Carro c JOIN c.acessorios a WHERE c.id =: idParam", Carro.class);
		query.setParameter("idParam", id);
		
		return query.getSingleResult();
	}


	public Carro buscaCarroComFoto(Long id) {
		TypedQuery<Carro> query = entityManager.createQuery("SELECT c FROM Carro c WHERE c.id =: idParam", Carro.class);
		query.setParameter("idParam", id);
		
		return query.getSingleResult();
	}


	public List<Carro> buscarComPaginacao(int first, int pageSize) {
		return entityManager.createNamedQuery("Carro.buscarTodos")
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();
	}


	public Long encontrarQuantidadeDeCarros() {
		return this.entityManager.createQuery("select count(c) from Carro c ", Long.class).getSingleResult();
	}
}
