package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pelicula extends Produccion {
	
	public Pelicula() {
		super();
	}

    public Pelicula(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                    int duracion,  Set<Genero> generos, HashSet<Director> directores, Set<String> actores,
                    String guion, String productora, String trailer, String poster,
                    Set<Plataforma> plataformas, List<Valoracion> valoraciones,TipoProduccion tipo) {
        super(id, titulo, calificacion, fechaLanzamiento, duracion, generos, directores, actores,
              guion, productora, trailer, poster, plataformas, valoraciones, tipo);
    }
    
}

