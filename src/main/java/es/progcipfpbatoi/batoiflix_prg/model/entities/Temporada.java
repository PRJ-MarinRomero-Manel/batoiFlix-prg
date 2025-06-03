package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;

public class Temporada {
	private int id;
	private LocalDate fechaLanzamiento;
	private String trama;
	private int capitulos;
	
	public Temporada(int id, LocalDate fechaLanzamiento, String trama, int capitulos) {
		this.id = id;
		this.fechaLanzamiento = fechaLanzamiento;
		this.trama = trama;
		this.capitulos = capitulos;
	}
	
	
}
