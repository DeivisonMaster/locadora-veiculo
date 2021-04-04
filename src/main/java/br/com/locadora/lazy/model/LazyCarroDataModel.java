package br.com.locadora.lazy.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import br.com.locadora.dao.CarroDAO;
import br.com.locadora.model.Carro;


public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable{
	private static final long serialVersionUID = 1L;
	private CarroDAO dao;

	public LazyCarroDataModel(CarroDAO dao) {
		this.dao = dao;
	}
	
	// first = a partir de qual id no banco se inicia a consulta / pageSize = quantidade de registros à retornar
	@Override
	public List<Carro> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Carro> carros = this.dao.buscarComPaginacao(first, pageSize);
		
		this.setRowCount(this.dao.encontrarQuantidadeDeCarros().intValue());
		
		return carros;
	}
}
