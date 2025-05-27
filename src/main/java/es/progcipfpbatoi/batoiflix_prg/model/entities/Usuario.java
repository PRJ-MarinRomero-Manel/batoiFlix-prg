package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.util.ArrayList;
import java.util.HashSet;

public class Usuario {
	private int id;
    private String nombre;
    private String apellidos;
    private String password;
    private String email;
    private String username;
    private String rol;
    private HashSet<Produccion> favoritos;
    private ArrayList<Produccion> historial;
    
	public Usuario(int id, String nombre, String apellidos, String password, String email, String username, String rol) {		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.username = username;
		this.rol = rol;
		this.favoritos = new HashSet<>();
		this.historial = new ArrayList<>();
	}
    
    

}
