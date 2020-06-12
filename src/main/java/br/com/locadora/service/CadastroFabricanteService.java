package br.com.locadora.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.locadora.dao.FabricanteDAO;
import br.com.locadora.model.Fabricante;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO dao;
	
	
	public void salvar(Fabricante fabricante) throws NegocioException {
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.dao.salvar(fabricante);
	}

}
