package br.com.locadora.security;

import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.locadora.util.cdi.UsuarioLogado;

@Named
@RequestScoped
public class Seguranca {
	
	@Inject
	private ExternalContext externalContext;
	
	public String getNomeUsuario() {
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if(usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}

	@Produces
	@UsuarioLogado
	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) userPrincipal;
		
		if(auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	public boolean isCadastrarFuncionario() {
		return this.externalContext.isUserInRole("ADMINISTRADOR") || this.externalContext.isUserInRole("VENDEDOR"); 
	}
}
