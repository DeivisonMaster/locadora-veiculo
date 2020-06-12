package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.MotoristaDAO;
import br.com.locadora.model.Motorista;

@FacesConverter(forClass = Motorista.class)
public class MotoristaConverter implements Converter{
	
	private MotoristaDAO dao;
	
	public MotoristaConverter() {
		this.dao = new MotoristaDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Motorista motorista = null;
		
		if(value != null){
			Long id = new Long(value);
			motorista = dao.buscarPorId(id);
		}
		return motorista;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Motorista motorista = (Motorista) value;
			return motorista.getId() == null ? null : motorista.getId().toString();
		}
		
		return "";
	}
}
