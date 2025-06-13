package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Produccion {
    protected int id;
    protected String titulo;
    protected Calificacion calificacion;
    protected LocalDate fechaLanzamiento;
    protected int duracion;
    protected Set<Genero> generos;
    protected HashSet<Director> directores;
    protected Set<String> actores;
    protected String guion;
    protected String productora;
    protected String trailer;
    protected String poster;
    protected Set<Plataforma> plataformas;
    protected List<Valoracion> valoraciones;
    protected TipoProduccion tipo;
    protected int visualizaciones = 0;

    public Produccion(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                      int duracion, Set<Genero> generos, HashSet<Director> directores, Set<String> actores,
                      String guion, String productora, String trailer, String poster,
                      Set<Plataforma> plataformas, List<Valoracion> valoraciones,
                      TipoProduccion tipo) {
        this.id = id;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.generos = generos;
        this.directores = directores;
        this.actores = actores;
        this.guion = guion;
        this.productora = productora;
        this.trailer = trailer;
        this.poster = poster;
        this.plataformas = plataformas;
        this.valoraciones = valoraciones;
        this.tipo = tipo;
        
    }
    public Produccion() {
        	
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
	public String getTitulo() {
		return titulo;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void addValoracion(Valoracion v) {
		valoraciones.add(v);
	}
	
	public void incrementarVisualizaciones() {
	    visualizaciones++;
	}

	public int getId() {
		return id;
	}
    }
