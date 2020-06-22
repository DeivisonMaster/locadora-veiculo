package br.com.locadora.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.jdbc.Work;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class ExecutaRelatorio implements Work{
	
	private String caminhoRelatorio;
	private String nomeArquivo;
	private  HttpServletResponse response;
	private Map<String, Object> parametros;
	
	
	public ExecutaRelatorio(HttpServletResponse response, String caminhoRelatorio, String nomeArquivo,
			Map<String, Object> parametros) {
		this.response = response;
		this.caminhoRelatorio = caminhoRelatorio;
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
	}

	@Override
	public void execute(Connection conexao) throws SQLException {
		try {
			InputStream stream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
			
			JasperPrint print = JasperFillManager.fillReport(stream, this.parametros, conexao);
			
			JRExporter exportador = new JRPdfExporter();
			exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, this.response.getOutputStream());
			exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);
			
			response.setContentType("application/pdf");
			//response.setHeader("Content-Disposition", "attachment; filename=\"" + this.nomeArquivo + "\"");
			
			exportador.exportReport();
			
		} catch (Exception e) {
			e.printStackTrace();
			//throw new SQLException("Erro ao executar o relatório: " + this.caminhoRelatorio, e);
		} 
	}

}
