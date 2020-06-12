//package com.algaworks.exemplos;
//
//import java.util.ArrayList;
//import java.util.List;
//
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
//@Table(name = "proprietario1")
//public class ProprietarioTabela1 {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String nome;
//	
//	@ElementCollection
//	@CollectionTable(name = "proprietario_telefone1",
//			joinColumns = @JoinColumn(name = "id_proprietario"))
//	@Column(name = "numero_telefone")
//	private List<String> telefones = new ArrayList<String>();  
//	
//	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	public List<String> getTelefones() {
//		return telefones;
//	}
//	public void setTelefones(List<String> telefones) {
//		this.telefones = telefones;
//	}
//	
//	
//	
//	
//}
