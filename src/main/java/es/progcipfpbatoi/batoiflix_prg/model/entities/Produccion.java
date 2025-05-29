package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.Set;

public abstract class Produccion {
	private int id;
	private String titulo;
	private Calificacion calificacion;
	private LocalDate fechaLanzamiento;
	private int duracion;
	private Set<Genero> generos;
	private String director;
	private Set<String> actores;
	private String guion;
	private String productora;
	private String trailer;
	private String poster;
	private Set<Plataforma> plataformas;
	
	
}
