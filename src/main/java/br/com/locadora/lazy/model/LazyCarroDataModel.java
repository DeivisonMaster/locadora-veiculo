package br.com.locadora.lazy.model;
//package com.algaworks.curso.jpa2.lazy.model;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortMeta;
//import org.primefaces.model.SortOrder;
//
//import com.algaworks.curso.jpa2.dao.CarroDAO;
//import com.algaworks.curso.jpa2.model.Carro;
//
//public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	private CarroDAO carroDAO;
//	
//	public LazyCarroDataModel(CarroDAO dao) {
//		this.carroDAO = dao;
//	}
//
//	
//	@Override
//	public List<Carro> load(int first, int pageSize, String sortField, SortOrder sortOrder,
//			Map<String, Object> filters) {
//		List<Carro> carros = this.carroDAO.buscarComPaginacao(first, pageSize);
//		
//		this.setRowCount(this.carroDAO.encontrarQuantidadeDeCarros().intValue());
//		
//		return carros;
//	}
//}
