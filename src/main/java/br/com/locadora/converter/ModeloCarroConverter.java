package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.ModeloCarroDAO;
import br.com.locadora.model.ModeloCarro;

@FacesConverter(forClass = ModeloCarro.class)
public class ModeloCarroConverter implements Converter{
	
	private ModeloCarroDAO dao;
	
	public ModeloCarroConverter() {
		this.dao = new ModeloCarroDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro modeloCarro = null;
		
		if(value != null){
			Long id = new Long(value);
			modeloCarro = dao.buscarPorId(id); 
		}
		return modeloCarro;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			ModeloCarro modeloCarro = (ModeloCarro) value;
			return modeloCarro.getId() == null ? null : modeloCarro.getId().toString();
		}
		
		return "";
	}
}
