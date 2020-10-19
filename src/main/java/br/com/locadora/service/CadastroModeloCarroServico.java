package br.com.locadora.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.locadora.dao.ModeloCarroDAO;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jpa.Transactional;

public class CadastroModeloCarroServico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroDAO dao;
	
	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException{
		if(modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("O nome do modelo é obrigatório");
		}
		
		if(modeloCarro.getFabricante() == null) {
			throw new NegocioException("O fabricante é obrigatório");
		}
		
		this.dao.salvar(modeloCarro);
	}
	
	
	public Collection<ModeloCarro> buscarTodos() {
		return this.dao.buscarTodos();
		
	}


	public void excluir(ModeloCarro modeloCarroSelecionado) throws NegocioException {
		try {
			this.dao.excluir(modeloCarroSelecionado);
			
		} catch (NegocioException e) {
			throw new NegocioException("Erro ao excluir o ModeloCarro");
		}
	}
	
}
