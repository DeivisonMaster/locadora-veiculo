package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.FabricanteDAO;
import br.com.locadora.model.Fabricante;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter{
	
	private FabricanteDAO dao;
	
	
	public FabricanteConverter() {
		this.dao = new FabricanteDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante fabricante = null;
		
		if(value != null){
			Long id = new Long(value);
			fabricante = dao.buscarPorId(id);
		}
		return fabricante;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Fabricante fabricante = (Fabricante) value;
			return fabricante.getId() == null ? null : fabricante.getId().toString();
		}
		
		return "";
	}
}
