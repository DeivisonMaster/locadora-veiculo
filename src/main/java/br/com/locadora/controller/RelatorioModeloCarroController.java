package br.com.locadora.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.locadora.dao.AluguelDAO;
import br.com.locadora.model.Usuario;
import br.com.locadora.security.UsuarioSistema;
import br.com.locadora.util.cdi.UsuarioLogado;
import javafx.scene.chart.CategoryAxis;

@Named
@RequestScoped
public class RelatorioModeloCarroController {
	
	private LineChartModel linearModel;
	private BarChartModel barModel;
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/"); 
	
	@Inject
	private AluguelDAO dao;
	
	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;
	
	/**
	 * Criação de gráficos web para visualização de relatórios de:
	 * - Carros mais alugados do mês/ano
	 * - Funcionários que alugam mais veiculos
	 * */
	/**
	 * @description Gráfico comparativo entre modelo de carros mais alugados do mês
	 * */
	public LineChartModel initLinearModel() {
		Usuario usuario = this.usuarioLogado.getUsuario();
		
		LineChartModel model = new LineChartModel();
		model.setTitle("Teste");
		model.setAnimate(true);
		model.setLegendPosition("e");
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
		
		LineChartSeries serie = new LineChartSeries();
		serie.setLabel("Todos os Aluguéis");
		
		Integer numeroDias = 40;
		Map<Date, BigDecimal> valoresPorData = this.dao.aluguelPorData(numeroDias, usuario);
		
		for (Date data : valoresPorData.keySet()) {
			serie.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}
		
		model.addSeries(serie);
		return model;
    }
	
	public BarChartModel initBarModel() {
		Usuario usuario = this.usuarioLogado.getUsuario();
		
		BarChartModel model = new BarChartModel();
		model.setTitle("Teste");
		model.setAnimate(true);
		model.setLegendPosition("e");
		
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Aluguel");
//		yAxis.setMin(0);
//		yAxis.setMax(10);
		
		ChartSeries serie = new ChartSeries();
		
		Integer numeroDias = 15;
		Map<Date, BigDecimal> valoresPorData = this.dao.aluguelPorData(numeroDias, usuario);
		
//		for (Date data : valoresPorData.keySet()) {
//			System.out.println(data + " " + valoresPorData.get(data));
//		}
		
		for (Date data : valoresPorData.keySet()) {
			serie.setLabel("Aluguel");
			serie.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}
		
		model.addSeries(serie);
		return model;

//		ChartSeries boys = new ChartSeries();
//		boys.setLabel("Boys");
//		boys.set("2004", 120);
//		boys.set("2005", 100);
//		boys.set("2006", 44);
//		boys.set("2007", 150);
//		boys.set("2008", 25);
//
//		ChartSeries girls = new ChartSeries();
//		girls.setLabel("Girls");
//		girls.set("2004", 52);
//		girls.set("2005", 60);
//		girls.set("2006", 110);
//		girls.set("2007", 135);
//		girls.set("2008", 120);
//		girls.set("2009", 550);
//
//		ChartSeries x = new ChartSeries();
//		x.setLabel("X");
//		x.set("2011", 52);
//		x.set("2005", 60);
//		x.set("2006", 110);
//		x.set("2007", 135);
//		x.set("2008", 120);
//
//		model.addSeries(boys);
//		model.addSeries(girls);
//		model.addSeries(x);
//
//		return model;
	}
	
	public LineChartModel getLinearModel() {
		return linearModel;
	}
	public BarChartModel getBarModel() {
		return barModel;
	}
}
