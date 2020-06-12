//package com.algaworks.exemplos;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
//import javax.persistence.Embedded;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import com.algaworks.curso.jpa2.model.Fabricante;
//import com.algaworks.curso.jpa2.model.ModeloCarro;
//
//@Entity
//@Table(name = "veiculo")
//public class Veiculo {
//	
//	@EmbeddedId
//	private VeiculoId id;
//	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	private Fabricante fabricante;
//	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	private ModeloCarro modelo;
//	
//	@Embedded
//	private Proprietario proprietario;
//
//	@Transient
//	public String getDescricao(){
//		return "Proprietario: " + this.getProprietario().getNome() + " Fabricante: " + this.getFabricante().getNome();
//	}
//	public VeiculoId getId() {
//		return id;
//	}
//	public void setId(VeiculoId id) {
//		this.id = id;
//	}
//	public Fabricante getFabricante() {
//		return fabricante;
//	}
//	public void setFabricante(Fabricante fabricante) {
//		this.fabricante = fabricante;
//	}
//	public ModeloCarro getModelo() {
//		return modelo;
//	}
//	public void setModelo(ModeloCarro modelo) {
//		this.modelo = modelo;
//	}
//	public Proprietario getProprietario() {
//		return proprietario;
//	}
//	public void setProprietario(Proprietario proprietario) {
//		this.proprietario = proprietario;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Veiculo other = (Veiculo) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//	
//	
//	
//}
