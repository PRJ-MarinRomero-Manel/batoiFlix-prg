package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.util.ArrayList;
import java.util.HashSet;

public class Usuario {
	private int id;
    private String nombre;
    private String apellidos;
    private String username;
    private String email;
    private String password;    
    private String rol;
    private HashSet<Produccion> favoritos;
    private ArrayList<Produccion> historial;
    
	public Usuario(int id, String nombre, String apellidos, String username, String email, String password, String rol,
			HashSet<Produccion> favoritos, ArrayList<Produccion> historial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.favoritos = favoritos;
		this.historial = historial;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean coincideContrasenya(String contrasenya) {
        return this.password.equals(contrasenya);
    }

	public HashSet<Produccion> getFavoritos() {
		return favoritos;
	}

	public ArrayList<Produccion> getHistorial() {
		return historial;
	}
}
