package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Serie extends Produccion {

    private List<Temporada> temporadas;
    
   
    public Serie(String titulo, String portada, List<Temporada> temporadas) {
		super(titulo, portada);
		this.temporadas = temporadas;
	}

	public Serie(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                 int duracion, Set<Genero> generos, Director director, String actores,
                 String guion, String productora, String trailer, String poster,
                 String plataformas, List<Valoracion> valoraciones,
                 List<Temporada> temporadas, TipoProduccion tipo) {

        super(id, titulo, calificacion, fechaLanzamiento, duracion, generos, director, actores,
              guion, productora, trailer, poster, plataformas, valoraciones, tipo);

        this.temporadas = temporadas;
    }
}
