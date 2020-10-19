package br.com.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.enumeracoes.EnumGrupo;
import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;

@Named("cadastroUsuario")
@ViewScoped
public class CadastroUsuarioController implements Serializable {
	
	private Usuario usuario;
	private EnumGrupo[] gruposSelecionados;
	
	@Inject
	private UsuarioDAO dao;
	
	
	public CadastroUsuarioController() {
		this.usuario = new Usuario();
	}
	
	
	public void cadastrar() {
		associaGrupoAoUsuario();
		
		this.dao.salva(usuario);
		
		this.usuario = new Usuario();
	}


	private void associaGrupoAoUsuario() {
		Grupo grupo = null;

		for (EnumGrupo g : this.gruposSelecionados) {
			grupo = new Grupo();
			grupo.setNome(g.getDescricao().toUpperCase());
			grupo.setDescricao(g.getDescricao());
			
			this.usuario.getGrupos().add(grupo);
		}
	}
	
	public EnumGrupo[] getGruposSelecionados() {
		return gruposSelecionados;
	}
	
	public void setGruposSelecionados(EnumGrupo[] gruposSelecionados) {
		this.gruposSelecionados = gruposSelecionados;
	}
	
	public EnumGrupo[] getGrupos() {
		return EnumGrupo.values();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
