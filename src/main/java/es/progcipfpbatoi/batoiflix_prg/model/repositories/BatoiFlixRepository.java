package es.progcipfpbatoi.batoiflix_prg.model.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import es.progcipfpbatoi.batoiflix_prg.exceptions.IncorrectPasswordException;
import es.progcipfpbatoi.batoiflix_prg.exceptions.NotFoundException;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Calificacion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Genero;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Pelicula;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Plataforma;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Produccion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.TipoProduccion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Usuario;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Valoracion;

@Repository
public class BatoiFlixRepository {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Produccion> producciones;

    public BatoiFlixRepository() {
        this.usuarios = new ArrayList<>();
        this.producciones = new ArrayList<>();
        //this.usuarios.add(new Usuario(1, "admin", "admin", "admin", "admin@gmail.com", "1234", "admin", null, null));    	
/**
        producciones.add(new Pelicula(
        	    1,
        	    "Argo",
        	    Calificacion.R,
        	    LocalDate.of(2012, 10, 12),
        	    120,
        	    Set.of(Genero.BIOGRAPHY, Genero.DRAMA, Genero.HISTORY),
        	    "Ben Affleck",
        	    Set.of("Ben Affleck", "Bryan Cranston", "Alan Arkin", "John Goodman"),
        	    "Acting under the cover of a Hollywood producer scouting a location for a science fiction film...",
        	    "Warner Bros. Pictures",
        	    "http://argothemovie.warnerbros.com",
        	    "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3MjI0MjM0NF5BMl5BanBnXkFtZTcwMTYxMTQ1OA@@._V1_SX300.jpg",
        	    Set.of(Plataforma.HBO, Plataforma.RAKUTEN),
        	    new ArrayList<>()
        	));
    
        producciones.add(new Pelicula(
    	    138,
    	    "The Karate Kid",
    	    Calificacion.PG,
    	    LocalDate.of(1984, 6, 22),
    	    126,
    	    Set.of(Genero.ACTION, Genero.DRAMA, Genero.FAMILY),
    	    "John G. Avildsen",
    	    Set.of("Ralph Macchio", "Pat Morita", "Elisabeth Shue", "Martin Kove"),
    	    "A martial arts master agrees to teach karate to a bullied teenager.",
    	    "Columbia Pictures",
    	    null,
    	    "https://images-na.ssl-images-amazon.com/images/M/MV5BNTkzY2YzNmYtY2ViMS00MThiLWFlYTEtOWQ1OTBiOGEwMTdhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    	    Set.of(Plataforma.RAKUTEN),
    	    new ArrayList<>()
    	));

        producciones.add(new Pelicula(
    	    139,
    	    "Back to the Future Part II",
    	    Calificacion.PG,
    	    LocalDate.of(1989, 11, 22),
    	    108,
    	    Set.of(Genero.ADVENTURE, Genero.COMEDY, Genero.SCI_FI),
    	    "Robert Zemeckis",
    	    Set.of("Michael J. Fox", "Christopher Lloyd", "Lea Thompson", "Thomas F. Wilson"),
    	    "After visiting 2015, Marty McFly must repeat his visit to 1955 to prevent disastrous changes to 1985...without interfering with his first trip.",
    	    "Universal Pictures",
    	    null,
    	    "https://images-na.ssl-images-amazon.com/images/M/MV5BZTMxMGM5MjItNDJhNy00MWI2LWJlZWMtOWFhMjI5ZTQwMWM3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    	    Set.of(Plataforma.RAKUTEN),
    	    new ArrayList<>()
    	));

        producciones.add(new Pelicula(
    	    140,
    	    "A Time to Kill",
    	    Calificacion.R,
    	    LocalDate.of(1996, 7, 24),
    	    149,
    	    Set.of(Genero.CRIME, Genero.DRAMA, Genero.THRILLER),
    	    "Joel Schumacher",
    	    Set.of("Matthew McConaughey", "Sandra Bullock", "Samuel L. Jackson", "Kevin Spacey"),
    	    "In Canton, Mississippi, a fearless young lawyer and his assistant defend a black man accused of murdering two white men who raped his 10-year-old daughter, inciting a revolt by local racist groups.",
    	    "Warner Home Video",
    	    null,
    	    "https://images-na.ssl-images-amazon.com/images/M/MV5BOWExZTg4ZWYtOTQxMi00YWZkLTkxYzgtOTg1MTUxNzNiNDcxL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    	    Set.of(Plataforma.HBO, Plataforma.NETFLIX, Plataforma.RAKUTEN),
    	    new ArrayList<>()
    	));

        producciones.add(new Pelicula(
    	    141,
    	    "A League of Their Own",
    	    Calificacion.PG,
    	    LocalDate.of(1992, 7, 1),
    	    128,
    	    Set.of(Genero.COMEDY, Genero.DRAMA, Genero.FAMILY),
    	    "Penny Marshall",
    	    Set.of("Tom Hanks", "Geena Davis", "Lori Petty", "Madonna"),
    	    "Two sisters join the first female professional baseball league and struggle to help it succeed amidst their own growing rivalry.",
    	    "Columbia Pictures",
    	    null,
    	    "https://images-na.ssl-images-amazon.com/images/M/MV5BODliMGQ1YzEtM2VhZi00MTU5LTllYTUtY2M3MDdjOTE4OGZlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    	    Set.of(Plataforma.HBO),
    	    new ArrayList<>()
    	));

        producciones.add(new Pelicula(
    	    142,
    	    "Back to the Future Part III",
    	    Calificacion.PG,
    	    LocalDate.of(1990, 5, 25),
    	    118,
    	    Set.of(Genero.ACTION, Genero.ADVENTURE, Genero.COMEDY),
    	    "Robert Zemeckis",
    	    Set.of("Michael J. Fox", "Christopher Lloyd", "Mary Steenburgen", "Thomas F. Wilson"),
    	    "Enjoying a peaceable existence in 1885, Doctor Emmet Brown is about to be killed by Buford \"Mad Dog\" Tannen. Marty McFly travels back in time to save his friend.",
    	    "MCA Universal Home Video",
    	    null,
    	    "https://images-na.ssl-images-amazon.com/images/M/MV5BYjhlMGYxNmMtOWFmMi00Y2M2LWE5NWYtZTdlMDRlMGEzMDA3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    	    Set.of(Plataforma.NETFLIX),
    	    new ArrayList<>()
    	));

        producciones.add(new Pelicula(
    		    143,
    		    "Bram Stoker's Dracula",
    		    Calificacion.R,
    		    LocalDate.of(1992, 11, 13),
    		    128,
    		    Set.of(Genero.FANTASY, Genero.HORROR),
    		    "Francis Ford Coppola",
    		    Set.of("Gary Oldman", "Winona Ryder", "Anthony Hopkins", "Keanu Reeves"),
    		    "The centuries old vampire Count Dracula comes to England to seduce his barrister Jonathan Harker's fiancée Mina Murray and inflict havoc in the foreign land.",
    		    "Columbia Pictures",
    		    null,
    		    "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYyOTM5NzU3Nl5BMl5BanBnXkFtZTgwOTQxNjAxNzE@._V1_SX300.jpg",
    		    Set.of(Plataforma.NETFLIX),
    		    new ArrayList<>()
    		));
    		*/
    		}        

    
    public Usuario validarLogin(String nombre, String contrasenya) {
        Usuario usuario = getByNombre(nombre);
        if (!usuario.coincideContrasenya(contrasenya)) {
            throw new IncorrectPasswordException("La contraseña no coincide");
        }
        return usuario;
    }

    public Usuario getById(int id) throws NotFoundException {
        for (Usuario user : usuarios) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new NotFoundException("El usuario con id " + id + " no existe");
    }

    public Usuario getByNombre(String n) throws NotFoundException {
        for (Usuario user : usuarios) {
            if (user.getNombre().equals(n)) {
                return user;
            }
        }
        throw new NotFoundException("El usuario con nombre " + n + " no existe");
    }
    
    public ArrayList<Produccion> getPeliculas(){
    	ArrayList<Produccion> peliculas = new ArrayList<>();
    	for(Produccion p : producciones) {
    		if(p.getTipo().equals(TipoProduccion.movie)) {
    			peliculas.add(p);
    		}
    	}
    	
    	return peliculas;
    }
    
    public ArrayList<Produccion> getSeries(){
    	ArrayList<Produccion> series = new ArrayList<>();
    	for(Produccion p : producciones) {
    		if(p.getTipo().equals(TipoProduccion.tv_show)) {
    			series.add(p);
    		}
    	}
    	
    	return series;
    }

    public ArrayList<Produccion> getMasRecomendados(){
    	    ArrayList<Produccion> copia = new ArrayList<>(producciones);

    	    Collections.sort(copia, new Comparator<Produccion>() {
    	        public int compare(Produccion p1, Produccion p2) {
    	            return Double.compare(p2.getMedia(), p1.getMedia());
    	        }
    	    });

    	    return copia;
    	}

    
    
    public ArrayList<Produccion> getByGenero(String genero, ArrayList<Produccion> listado) {
        ArrayList<Produccion> generos = new ArrayList<>();
        try {
            Genero generoE = Genero.valueOf(genero.toUpperCase());
            for (Produccion p : listado) {
                if (p.getGeneros().contains(generoE)) {
                    generos.add(p);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Género no válido: " + genero);
        }
        return generos;
    }
    
    public Produccion getProduccionByNombre(String nombre) throws NotFoundException {
    	for(Produccion p : producciones) {
    		if(p.getTitulo().equalsIgnoreCase(nombre)) {
    			return p;
    		}
    	}
    	throw new NotFoundException("La pelicula/serie de nombre "+nombre+" no existe");
    }
    
    public ArrayList<Produccion> getOrdenarPorFecha(ArrayList<Produccion> listado, boolean descendente) {
        listado.sort(descendente
            ? Comparator.comparing(Produccion::getFechaLanzamiento).reversed()
            : Comparator.comparing(Produccion::getFechaLanzamiento)
        );
        return listado;
    }

    public void hacerValoracion(Produccion p,Valoracion v) {
    	p.addValoracion(v);
    }
    
    public HashSet<Produccion> getListadoFavoritos(Usuario u){
    	return u.getFavoritos();
    }
    
    public ArrayList<Produccion> getListadoHistorial(Usuario u){
    	return u.getHistorial();
    }

}


