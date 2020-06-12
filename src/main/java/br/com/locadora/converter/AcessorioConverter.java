package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.AcessorioDAO;
import br.com.locadora.model.Acessorio;

@FacesConverter(forClass = Acessorio.class)
public class AcessorioConverter implements Converter{
	
	private AcessorioDAO dao;
	
	public AcessorioConverter() {
		this.dao = new AcessorioDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio acessorio = null;
		
		if(value != null){
			Long id = new Long(value);
			acessorio = dao.buscarPorId(id); 
		}
		return acessorio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Acessorio acessorio = (Acessorio) value;
			return acessorio.getId() == null ? null : acessorio.getId().toString();
		}
		
		return "";
	}
}
