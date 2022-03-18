package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> lista;
	
	public Parole() {
		//TODO
		//lista = new ArrayList<String>();
		lista = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		lista.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(lista);
		return lista;
	}
	
	public void reset() {
		// TODO
		this.lista.clear();
	}
	
	public void cancella(String p) {
		
		this.lista.remove(p);
	}
	
	

}