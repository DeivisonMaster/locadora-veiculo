package br.com.locadora.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private ExternalContext externalContext;
	
	public void login() throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
		context.responseComplete();
		
	}
	
	/**
	 * @description Método invocado antes da pagina ser renderizada
	 * */
	public void preRender() {
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		if("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou Senha incorretos!");
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
