package br.com.locadora.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	private String chassi;
	private String cor;
	
	@Column(name = "valor_diaria")
	private BigDecimal valorDiaria;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carro_acessorio",
			joinColumns = @JoinColumn(name = "id_carro"), 
			inverseJoinColumns = @JoinColumn(name = "id_acessorio"))
	private Collection<Acessorio> acessorios = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_modelo_carro")
	private ModeloCarro modeloCarro;
	
	@OneToMany(mappedBy = "carro")
	private Collection<Aluguel> aluguel;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public Collection<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(Collection<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	public Collection<Aluguel> getAluguel() {
		return aluguel;
	}
	public void setAluguel(Collection<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
