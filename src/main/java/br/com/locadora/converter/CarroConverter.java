package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.AcessorioDAO;
import br.com.locadora.dao.CarroDAO;
import br.com.locadora.model.Carro;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter{
	
	private CarroDAO dao;
	
	public CarroConverter() {
		this.dao = new CarroDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro carro = null;
		
		if(value != null){
			Long id = new Long(value);
			carro = dao.buscarPorId(id); 
		}
		return carro;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Carro carro = (Carro) value;
			return carro.getId() == null ? null : carro.getId().toString();
		}
		
		return "";
	}
}
