package br.com.locadora.lazy.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.locadora.dao.ModeloCarroDAO;
import br.com.locadora.model.ModeloCarro;


public class LazyModeloCarroDataModel extends LazyDataModel<ModeloCarro> implements Serializable{

	private ModeloCarroDAO modeloCarroDao;

	public LazyModeloCarroDataModel(ModeloCarroDAO modeloCarroDao) {
		this.modeloCarroDao = modeloCarroDao;
	}
	
	
	@Override
	public List<ModeloCarro> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<ModeloCarro> listaModeloCarro = this.modeloCarroDao.buscarComPaginacao(first, pageSize);

		this.setRowCount(this.modeloCarroDao.encontrarQuantidadeDeModeloCarro().intValue());
		
		return listaModeloCarro;
	}
}
