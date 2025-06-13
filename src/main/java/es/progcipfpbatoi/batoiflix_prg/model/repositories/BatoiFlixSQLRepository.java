package es.progcipfpbatoi.batoiflix_prg.model.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.progcipfpbatoi.batoiflix_prg.config.MySQLConnection;
import es.progcipfpbatoi.batoiflix_prg.exceptions.IncorrectPasswordException;
import es.progcipfpbatoi.batoiflix_prg.exceptions.NotFoundException;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Calificacion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Director;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Genero;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Pelicula;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Plataforma;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Produccion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.TipoProduccion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Usuario;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Valoracion;

@Repository
public class BatoiFlixSQLRepository {

    @Autowired
    private MySQLConnection mySQLConnection;
    

    public Usuario validarLogin(String nombre, String contrasenya) {
        Usuario usuario = getByNombre(nombre);
        if (!usuario.coincideContrasenya(contrasenya)) {
            throw new IncorrectPasswordException("La contraseña no coincide");
        }
        return usuario;
    }


    public Usuario getById(int id) throws NotFoundException {
        String query = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                } else {
                    throw new NotFoundException("El usuario con id " + id + " no existe");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error en getById: " + e.getMessage(), e);
        }
    }


    public Usuario getByNombre(String n) throws NotFoundException {
        String query = "SELECT * FROM Usuario WHERE nombre = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, n);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                } else {
                    throw new NotFoundException("El usuario con nombre " + n + " no existe");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error en getByNombre: " + e.getMessage(), e);
        }
    }
    
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String rol = rs.getString("rol");

        return new Usuario(id, nombre, apellidos, username, email, password, rol);
    }
    
    
 
public ArrayList<Pelicula> getPeliculas() {
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    String query = "SELECT p.titulo, p.portada " +
                   "FROM Produccion p " +
                   "WHERE p.tipo = 'movie'";

    try (
        Connection con = mySQLConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)
    ) {
        while (rs.next()) {
            String titulo = rs.getString("titulo");
            String poster = rs.getString("portada");

            Pelicula pelicula = new Pelicula(titulo, poster);

            peliculas.add(pelicula);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener películas: " + e.getMessage());
    }

    return peliculas;
}


/**



    // Historia de usuario 1 y 2: Obtiene las series (tipo 'tv_show')
    public ArrayList<Produccion> getSeries(){
        ArrayList<Produccion> series = new ArrayList<>();
        String query = "SELECT * FROM produccion WHERE tipo = 'tv_show'";
        try (Connection con = mySQLConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()){
                series.add(mapearProduccion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series;
    }
    
    // Historia de usuario 1: Obtiene las producciones ordenadas por media de valoración (más recomendadas)
    public ArrayList<Produccion> getMasRecomendados(){
        ArrayList<Produccion> lista = new ArrayList<>();
        String query = "SELECT * FROM produccion ORDER BY media DESC";
        try (Connection con = mySQLConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()){
                lista.add(mapearProduccion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // Historia de usuario 3: Filtra producciones por género (se asume que en la columna 'generos' se guarda en formato CSV)
    public ArrayList<Produccion> getByGenero(String genero){
        ArrayList<Produccion> lista = new ArrayList<>();
        String query = "SELECT * FROM produccion WHERE UPPER(generos) LIKE ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "%" + genero.toUpperCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    lista.add(mapearProduccion(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // Historia de usuario 4: Busca una producción por su título
    public Produccion getProduccionByNombre(String nombre) throws NotFoundException {
        String query = "SELECT * FROM produccion WHERE LOWER(titulo) = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombre.toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    return mapearProduccion(rs);
                } else {
                    throw new NotFoundException("La película/serie de nombre " + nombre + " no existe");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error en getProduccionByNombre: " + e.getMessage(), e);
        }
    }
    
    // Historia de usuario 5: Ordena producciones por fecha de estreno (año)
    public ArrayList<Produccion> getProduccionesOrdenadasPorFecha(boolean descendente){
        ArrayList<Produccion> lista = new ArrayList<>();
        String order = descendente ? "DESC" : "ASC";
        String query = "SELECT * FROM produccion ORDER BY fecha_lanzamiento " + order;
        try (Connection con = mySQLConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()){
                lista.add(mapearProduccion(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    // Historia de usuario 6 y 12: Valora una producción (inserta en la tabla 'valoracion')
    public void hacerValoracion(Produccion p, Valoracion v){
        String query = "INSERT INTO valoracion (produccion_id, usuario_id, puntuacion, comentario) VALUES (?, ?, ?, ?)";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, p.getId());
            ps.setInt(2, v.getUsuarioId()); // Se asume que Valoracion tiene este campo/método
            ps.setDouble(3, v.getNota());
            ps.setString(4, v.getMensaje());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    // Historia de usuario 8: Obtiene la lista de producciones favoritas de un usuario
    public HashSet<Produccion> getListadoFavoritos(Usuario u){
        HashSet<Produccion> favoritos = new HashSet<>();
        String query = "SELECT p.* FROM produccion p INNER JOIN favoritos f ON p.id = f.produccion_id WHERE f.usuario_id = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, u.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    favoritos.add(mapearProduccion(rs));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return favoritos;
    }
    
    // Historia de usuario 11: Obtiene el historial de visualizaciones de un usuario
    public ArrayList<Produccion> getListadoHistorial(Usuario u){
        ArrayList<Produccion> historial = new ArrayList<>();
        String query = "SELECT p.* FROM produccion p INNER JOIN historial h ON p.id = h.produccion_id WHERE h.usuario_id = ? ORDER BY h.fecha DESC";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, u.getId());
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    historial.add(mapearProduccion(rs));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return historial;
    }
    
    // Historia de usuario 2 (opcional): Obtiene las producciones disponibles en una plataforma de streaming
    public ArrayList<Produccion> getProduccionesPorPlataforma(String plataforma){
        ArrayList<Produccion> lista = new ArrayList<>();
        String query = "SELECT * FROM produccion WHERE plataforma = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, plataforma);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    lista.add(mapearProduccion(rs));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    // Historia de usuario 9: Incrementa el contador de visualizaciones de una producción
    public void incrementarVisualizaciones(Produccion p) {
        String query = "UPDATE produccion SET visualizaciones = visualizaciones + 1 WHERE id = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Historia de usuario 9: Obtiene el número de visualizaciones de una producción
    public int getVisualizaciones(Produccion p) {
        String query = "SELECT visualizaciones FROM produccion WHERE id = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, p.getId());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return rs.getInt("visualizaciones");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // Historia de usuario 10: Obtiene una lista paginada de producciones
    public ArrayList<Produccion> getProduccionesPaginadas(int offset, int limit) {
        ArrayList<Produccion> lista = new ArrayList<>();
        String query = "SELECT * FROM produccion LIMIT ? OFFSET ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    lista.add(mapearProduccion(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    // Historia de usuario 10: Actualiza la información de una producción existente
    public void actualizarProduccion(Produccion p) {
        String query = "UPDATE produccion SET titulo = ?, media = ?, fecha_lanzamiento = ?, " +
                       "tipo = ?, duracion = ?, generos = ?, guion = ?, url_trailer = ?, poster = ?, plataforma = ? " +
                       "WHERE id = ?";
        try (Connection con = mySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, p.getTitulo());
            ps.setDouble(2, p.getMedia());
            ps.setDate(3, java.sql.Date.valueOf(p.getFechaLanzamiento()));
            ps.setString(4, p.getTipo().toString());
            ps.setInt(5, p.getDuracion());
            ps.setString(6, p.getGenerosCSV()); // Se supone que la entidad tiene un método para obtener los géneros en CSV.
            ps.setString(7, p.getGuion());
            ps.setString(8, p.getUrlTrailer());
            ps.setString(9, p.getPoster());
            ps.setString(10, p.getPlataforma());
            ps.setInt(11, p.getId());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }    

    
    public Produccion mapearProduccion(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String titulo = rs.getString("titulo");
        String calificacion = rs.getString("calificacion");
        LocalDate fechaLanzamiento = rs.getDate("fechaLanzamiento").toLocalDate();
        int duracion = rs.getInt("duracion");       
        Set<Genero> generos = obtenerGenerosDesdeResultSet(rs);
        String director = rs.getString("director");
        Set<String> actores = obtenerActoresDesdeResultSet(rs);
        String guion = rs.getString("guion");
        String productora = rs.getString("productora");
        String trailer = rs.getString("trailer");
        String poster = rs.getString("poster");
        Set<Plataforma> plataformas = obtenerPlataformasDesdeResultSet(rs);
        List<Valoracion> valoraciones = obtenerValoracionesDesdeResultSet(rs);
        TipoProduccion tipo = TipoProduccion.valueOf(rs.getString("tipo"));

        Produccion produccion;
        if (tipo == TipoProduccion.PELICULA) {
            produccion = new Pelicula(id, titulo, calificacion, fechaLanzamiento, duracion, generos,
                                      director, actores, guion, productora, trailer, poster, plataformas,
                                      valoraciones, tipo);
        } else if (tipo == TipoProduccion.SERIE) {
            produccion = new Serie(id, titulo, calificacion, fechaLanzamiento, duracion, generos,
                                  director, actores, guion, productora, trailer, poster, plataformas,
                                  valoraciones, tipo);
        } else {
            throw new SQLException("Tipo de producción desconocido: " + tipo);
        }
        
        return produccion;
    }
    */
}
