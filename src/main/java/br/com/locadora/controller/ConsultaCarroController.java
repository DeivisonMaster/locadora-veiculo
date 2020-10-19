package br.com.locadora.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.locadora.dao.CarroDAO;
import br.com.locadora.lazy.model.LazyCarroDataModel;
//import br.com.locadora.lazy.model.LazyCarroDataModel;
import br.com.locadora.model.Carro;
import br.com.locadora.service.CadastroCarroService;
import br.com.locadora.util.ErroConstraintException;
import br.com.locadora.util.NegocioException;
import br.com.locadora.util.jsf.FacesUtil;
import sun.awt.image.ByteArrayImageSource;

@Named("consultaCarro")
@SessionScoped
public class ConsultaCarroController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Carro carroSelecionado;
	private Collection<Carro> listaCarros;
	private BufferedImage imagemCarro;
	private LazyCarroDataModel lazyCarro;
	private List<Carro> carros;
	
	@Inject
	private CadastroCarroService serviceCarro;
	
	@Inject
	private CarroDAO dao;
	
	@PostConstruct
	public void init() {
		this.limpar();
		//this.listaCarros = this.dao.buscarTodos();
		this.lazyCarro = new LazyCarroDataModel(dao);
	}
	
	
	public void excluir() {
		try {
			this.serviceCarro.excluir(this.carroSelecionado);
			
		} catch (Exception e) {
			Throwable cause = e.getCause();
			FacesUtil.addErrorMessage(cause.getMessage());
		}
	}
	
	public void limpar() {
		this.carroSelecionado = new Carro();
	}
	
	public void buscaCarroComAcessorio() {
		this.carroSelecionado = this.dao.buscaCarroComAcessorio(this.carroSelecionado.getId());
	}
	
	public void buscaCarroComFoto(){
		this.carroSelecionado = this.dao.buscaCarroComFoto(this.carroSelecionado.getId());
		
		if(this.carroSelecionado.getFoto() != null) {
			try {
				BufferedImage imagem = ImageIO.read(new ByteArrayInputStream(this.carroSelecionado.getFoto()));
				
				this.imagemCarro = imagem;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public StreamedContent getFoto() {
		DefaultStreamedContent content = null;
		
		if (this.carroSelecionado != null && this.carroSelecionado.getFoto() != null
				&& this.carroSelecionado.getFoto().length > 0) {
			
			byte[] imagem = this.carroSelecionado.getFoto();
			
			content = new DefaultStreamedContent(new ByteArrayInputStream(imagem), "image/jpg", "carro.jpg");
		}
		
		return content;
	}
	
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}
	public Collection<Carro> getListaCarros() {
		this.listaCarros = this.dao.buscarTodos();
		return listaCarros;
	}
	public BufferedImage getImagemCarro() {
		return imagemCarro;
	}
	public void setImagemCarro(BufferedImage imagemCarro) {
		this.imagemCarro = imagemCarro;
	}
	public LazyCarroDataModel getLazyCarro() {
		return lazyCarro;
	}
}
