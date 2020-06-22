package br.com.locadora.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import br.com.locadora.dao.AluguelDAO;
import br.com.locadora.model.Aluguel;
import br.com.locadora.security.UsuarioSistema;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.cdi.UsuarioLogado;
import br.com.locadora.util.jpa.Transactional;

public class CadastroAluguelService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AluguelDAO dao;
	
	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;
	
	
	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException{
		
		if(aluguel.getCarro() == null) {
			throw new NegocioException("O carro é obrigatório");
		}
		
		aluguel.setUsuario(usuarioLogado.getUsuario().getNome());
		aluguel.setDataPedido(Calendar.getInstance());
		
		this.dao.salvar(aluguel);
	}

}
