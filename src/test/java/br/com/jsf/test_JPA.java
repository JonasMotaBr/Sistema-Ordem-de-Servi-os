package br.com.jsf;

import javax.persistence.Persistence;

public class test_JPA {
	
	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("Projeto_JSF");
		
	}
	

}
