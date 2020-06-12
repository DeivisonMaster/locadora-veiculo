package br.com.locadora.controller;
//package com.algaworks.curso.jpa2.controller;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
//import com.algaworks.curso.jpa2.lazy.model.LazyModeloCarroDataModel;
//import com.algaworks.curso.jpa2.model.ModeloCarro;
//import com.algaworks.curso.jpa2.service.CadastroModeloCarroServico;
//
//@Named("consultaModeloCarro")
//@ViewScoped
//public class ConsultaModeloCarroController implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	@Inject
//	private CadastroModeloCarroServico serviceModeloCarro;
//	private Collection<ModeloCarro> listaModeloCarro;
//	private ModeloCarro modeloCarroSelecionado;
//	
//	@Inject
//	private ModeloCarroDAO modeloCarroDao;
//	
//	private LazyModeloCarroDataModel lazyModeloCarro;
//	
//	public ConsultaModeloCarroController() {
//		this.modeloCarroSelecionado = new ModeloCarro();
//	}
//	
//	
//	@PostConstruct
//	public void init() {
//		this.lazyModeloCarro = new LazyModeloCarroDataModel(this.modeloCarroDao);
//		//this.listaModeloCarro = serviceModeloCarro.buscarTodos();
//	}
//	
//	public void excluir() {
//		
//	}
//	
//	
//	public LazyModeloCarroDataModel getLazyModeloCarro() {
//		return lazyModeloCarro;
//	}
//	
//	public Collection<ModeloCarro> getListaModeloCarro() {
//		return listaModeloCarro;
//	}
//	public ModeloCarro getModeloCarroSelecionado() {
//		return modeloCarroSelecionado;
//	}
//	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
//		this.modeloCarroSelecionado = modeloCarroSelecionado;
//	}
//}
