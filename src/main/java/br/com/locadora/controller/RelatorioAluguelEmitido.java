package br.com.locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.locadora.util.ExecutaRelatorio;
import br.com.locadora.util.jpa.EntityManagerProducer;

@Named
@RequestScoped
public class RelatorioAluguelEmitido {
	
	private Date dataInicio;
	private Date dataFim;
	private String paramDataInicio;
	private String paramDataFim;
	
	
	private EntityManager em;
	
//	@Inject
//	private ExternalContext externalContext;
	
	private HttpServletResponse response;
	
	public RelatorioAluguelEmitido() {
		this.em = new EntityManagerProducer().create();
	}
	
	public void emitir() throws ParseException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		this.response = (HttpServletResponse) externalContext.getResponse();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		this.dataInicio = conversorData(this.dataInicio);
		this.dataFim = conversorData(this.dataFim);
		
		parametros.put("DATA_INI", this.dataInicio);
		parametros.put("DATA_FIM", this.dataFim);
		
		ExecutaRelatorio executor = new ExecutaRelatorio(this.response, "/resources/relatorio_aluguel.jasper", "relatorio_aluguel", parametros);
		
		Session session = this.em.unwrap(Session.class);
		session.doWork(executor);
		
		this.dataInicio = new Date();
		this.dataFim = new Date();
		facesContext.responseComplete(); // encerra o processamento do ciclo de vida JSF e exibe a página 
	}
	
	private Date conversorData(Date data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(data);
		Date novaData = sdf.parse(dataFormatada);
		
		return novaData;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getParamDataInicio() {
		return paramDataInicio;
	}

	public void setParamDataInicio(String paramDataInicio) {
		this.paramDataInicio = paramDataInicio;
	}

	public String getParamDataFim() {
		return paramDataFim;
	}

	public void setParamDataFim(String paramDataFim) {
		this.paramDataFim = paramDataFim;
	}
	
	
	
}
