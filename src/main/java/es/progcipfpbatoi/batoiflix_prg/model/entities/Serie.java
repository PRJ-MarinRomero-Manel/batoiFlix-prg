package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Serie extends Produccion {

    private List<Temporada> temporadas;

    public Serie(int id, String titulo, Calificacion calificacion, LocalDate fechaLanzamiento,
                 int duracion, Set<Genero> generos, String director, Set<String> actores,
                 String guion, String productora, String trailer, String poster,
                 Set<Plataforma> plataformas, List<Valoracion> valoraciones,
                 List<Temporada> temporadas) {

        super(id, titulo, calificacion, fechaLanzamiento, duracion, generos, director, actores,
              guion, productora, trailer, poster, plataformas, valoraciones, TipoProduccion.tv_show);

        this.temporadas = temporadas;
    }
}
