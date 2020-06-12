package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.locadora.model.Aluguel;
import br.com.locadora.model.ApoliceSeguro;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Motorista;
import br.com.locadora.service.CadastroAluguelService;
import br.com.locadora.service.CadastroCarroService;
import br.com.locadora.service.CadastroMotoristaService;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;

@Named("cadastroAluguel")
@ViewScoped
public class CadastroAluguelController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Aluguel aluguel;
	private Collection<Carro> carros;
	private Collection<Motorista> motoristas;
	
	@Inject
	private CadastroCarroService carroService;
	
	@Inject
	private CadastroAluguelService aluguelService;
	
	@Inject
	private CadastroMotoristaService motoristaService;
	
	
	@PostConstruct
	public void init() {
		this.limpar();
		
		this.carros = carroService.buscaTodos();
		this.motoristas = motoristaService.buscaTodos();
	}
	
	
	public void salvar() {
		try {
			this.aluguelService.salvar(this.aluguel);
			FacesUtil.addSuccessMessage("Aluguel cadastrado com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addSuccessMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	public Collection<Carro> getCarros() {
		return carros;
	}
	public Collection<Motorista> getlistaDeMotoristas() {
		return motoristas;
	}

}
