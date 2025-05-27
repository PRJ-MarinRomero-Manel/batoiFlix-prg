package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.util.ArrayList;

public class Serie extends Produccion{
	private ArrayList<Temporada> temporadas;
	
	public Serie() {
		super();
		this.temporadas = new ArrayList<>();
	}
}
