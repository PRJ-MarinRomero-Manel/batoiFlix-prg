package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pelicula extends Produccion {
	
	public Pelicula(String titulo, String portada) {
		super(titulo, portada);
	}

	public Pelicula(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                    int duracion,  Set<Genero> generos, Director director, String actores,
                    String guion, String productora, String trailer, String poster,
                    String plataformas, List<Valoracion> valoraciones,TipoProduccion tipo) {
        super(id, titulo, calificacion, fechaLanzamiento, duracion, generos, director, actores,
              guion, productora, trailer, poster, plataformas, valoraciones, tipo);
    }
    
}

