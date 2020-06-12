package br.com.locadora.model;

public enum Categoria {
	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch Médio"),
	SEDAN_COMPACTO("Sedã Compacto"),
	SEDAN_MEDIO("Sedã Médio"),
	SEDAN_GRANDE("Sedã Grande"),
	MINIVAM("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitário Comercial");
	
	private String descricao;
	
	Categoria(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
