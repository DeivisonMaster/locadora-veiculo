package br.com.locadora.lazy.model;
//package com.algaworks.curso.jpa2.lazy.model;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortOrder;
//
//import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
//import com.algaworks.curso.jpa2.model.ModeloCarro;
//
//public class LazyModeloCarroDataModel extends LazyDataModel<ModeloCarro> implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	private ModeloCarroDAO modeloCarroDAO;
//	
//	public LazyModeloCarroDataModel(ModeloCarroDAO modeloCarroDAO) {
//		this.modeloCarroDAO = modeloCarroDAO;
//	}
//	
//	@Override
//	public List<ModeloCarro> load(int first, int pageSize, String sortField, SortOrder sortOrder,
//			Map<String, Object> filters) {
//		
//		List<ModeloCarro> listaModeloCarro = this.modeloCarroDAO.buscarComPaginacao(first, pageSize);
//		this.setRowCount(this.modeloCarroDAO.encontrarQuantidadeDeModeloCarro().intValue());
//		
//		return listaModeloCarro;
//	}
//	
//}
