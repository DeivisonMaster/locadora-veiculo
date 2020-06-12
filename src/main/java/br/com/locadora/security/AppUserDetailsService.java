package br.com.locadora.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;

public class AppUserDetailsService implements UserDetailsService{
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(); //CDIServiceLocator.getBean(UsuarioRepository.class);
		Usuario usuario = usuarioDAO.buscaPorEmail(email);
		
		UsuarioSistema usuarioSistema = null;
		
		if(usuario != null) {
			usuarioSistema = new UsuarioSistema(usuario, getGruposDo(usuario));
		}
		
		return usuarioSistema;
	}

	
	private Collection<? extends GrantedAuthority> getGruposDo(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}
}
