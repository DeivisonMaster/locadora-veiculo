package com.algaworks.exemplos;

import br.com.locadora.model.Fabricante;

public class EqualsHashCode {
	public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		f1.setId(1L);
		
		Fabricante f2 = f1;
		f2.setId(12L);
		
		System.out.println(f1.equals(f2));
	}
}
