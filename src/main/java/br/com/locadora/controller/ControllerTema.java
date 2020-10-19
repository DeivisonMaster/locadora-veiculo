package br.com.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("controllerTema")
@SessionScoped
public class ControllerTema implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<String> temas;
	private String tema = "start"; // aristo, start, omega, sam, cupertino, flick, start
	
	public ControllerTema() {
		this.temas = new ArrayList<>();
		
		this.temas = Arrays.asList("afterdark", "afternoon", "afterwork", "aristo", "black-tie", "blitzer", "bluesky",
				"bootstrap", "casablanca", "cupertino", "cruze", "dark-hive", "delta", "dot-luv", "eggplant",
				"excite-bike", "flick", "glass-x", "home", "hot-sneaks", "humanity", "le-frog", "midnight", "mint-choc",
				"overcast", "pepper-grinder", "redmond", "rocket", "sam", "smoothness", "south-street", "start",
				"sunny", "swanky-purse", "trontastic", "ui-darkness", "ui-lightness", "vader");
	}
	
	public List<String> getTemas() {
		return temas;
	}
	
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
}




























