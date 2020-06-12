package br.com.locadora.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.locadora.dao.AcessorioDAO;
import br.com.locadora.dao.FabricanteDAO;
import br.com.locadora.model.Acessorio;
import br.com.locadora.model.Fabricante;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class CadastroAcessorioService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private AcessorioDAO dao;
	
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		if(acessorio.getDescricao() == null || acessorio.getDescricao().trim().equals("")) {
			throw new NegocioException("A descrição do acessório é obrigatória");
		}
		
		this.dao.salvar(acessorio);
	}
}
