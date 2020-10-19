package br.com.locadora.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.locadora.model.Usuario;
import br.com.locadora.util.jpa.EntityManagerProducer;
import br.com.locadora.util.jpa.Transactional;

public class UsuarioDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public UsuarioDAO() {
		this.entityManager = new EntityManagerProducer().create();
	}
	
	
	@Transactional
	public void salva(Usuario usuario) {
		this.entityManager.merge(usuario);
	}

	
	public Usuario buscaPorId(Long id) {
		return this.entityManager.find(Usuario.class, id);
	}
	
	public List<Usuario> buscaPorVendedores(){
		// TODO filtrar apenas vendedores por um grupo especifico
		TypedQuery<Usuario> usuario = this.entityManager.createQuery("from Usuario", Usuario.class);
		List<Usuario> usuarioPesquisado = usuario.getResultList();
		
		return usuarioPesquisado;
	}

	public void excluirUsuario(Usuario usuarioSelecionado) {
		this.entityManager.remove(usuarioSelecionado);
	}

	public Usuario buscaPorEmail(String email) {
		Usuario usuario = null;
		
		try {
			TypedQuery<Usuario> query = this.entityManager.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
			query.setParameter("email", email.toLowerCase());
			
			usuario = query.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
}
