package br.com.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locadora.dao.FuncionarioDAO;
import br.com.locadora.model.Funcionario;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter{
	private FuncionarioDAO dao;
	
	public FuncionarioConverter() {
		this.dao = new FuncionarioDAO();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario funcionario = null;
		
		if(value != null){
			Long id = new Long(value);
			funcionario = dao.buscarPorId(id);
		}
		return funcionario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Funcionario funcionario = (Funcionario) value;
			return funcionario.getId() == null ? null : funcionario.getId().toString();
		}
		
		return "";
	}
}
