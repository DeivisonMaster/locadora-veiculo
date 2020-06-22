package br.com.locadora.model;

import java.util.Date;

public class DataAluguel {
	private Date data;
	private Aluguel aluguel;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	
	
	
}
