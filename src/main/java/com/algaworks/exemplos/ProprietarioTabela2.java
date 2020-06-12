//package com.algaworks.exemplos;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "proprietario2")
//public class ProprietarioTabela2 {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String nome;
//	
//	@ElementCollection
//	@CollectionTable(name = "proprietario_telefone2",
//			joinColumns = @JoinColumn(name = "id_proprietario"))
//	@AttributeOverrides({
//		@AttributeOverride(name = "numero", column = @Column(name = "numero_telefone"))
//	})
//	private List<Telefone> telefones = new ArrayList<Telefone>();
//
//	
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public List<Telefone> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(List<Telefone> telefones) {
//		this.telefones = telefones;
//	} 
//	
//	
//	
//	
//}
