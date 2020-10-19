package br.com.locadora.enumeracoes;

public enum EnumGrupo {
	AUXILIAR("Auxiliar"),
	VENDEDOR("Vendedor"),
	ADMINISTRADOR("Administrador");
	
	private String descricao;
	
	EnumGrupo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
