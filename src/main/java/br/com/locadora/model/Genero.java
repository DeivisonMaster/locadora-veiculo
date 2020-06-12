package br.com.locadora.model;

public enum Genero {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;
	
	Genero(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
