package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public abstract class Produccion {
    protected int id;
    protected String titulo;
    protected Calificacion calificacion;
    protected LocalDate fechaLanzamiento;
    protected int duracion;
    protected Set<Genero> generos;
    protected String director;
    protected Set<String> actores;
    protected String guion;
    protected String productora;
    protected String trailer;
    protected String poster;
    protected Set<Plataforma> plataformas;
    protected List<Valoracion> valoraciones;
    protected TipoProduccion tipo;

    public Produccion(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                      int duracion, Set<Genero> generos, String director, Set<String> actores,
                      String guion, String productora, String trailer, String poster,
                      Set<Plataforma> plataformas, List<Valoracion> valoraciones,
                      TipoProduccion tipo) {
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.generos = generos;
        this.director = director;
        this.actores = actores;
        this.guion = guion;
        this.productora = productora;
        this.trailer = trailer;
        this.poster = poster;
        this.plataformas = plataformas;
        this.valoraciones = valoraciones;
        this.tipo = tipo;
        }

	public TipoProduccion getTipo() {
		return tipo;
		}
	
    public double getMedia() {
    	double suma = 0;
    	for(Valoracion v : valoraciones) {
    		suma += v.getNota();
    	}
    	return suma;
    	}

	public Set<Genero> getGeneros() {
		return generos;
	}
    }
