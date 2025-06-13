package es.progcipfpbatoi.batoiflix_prg.model.entities;

import java.time.LocalDate;

public class Director {
	int id;
	String dni;
	String nombre;
	LocalDate fechaLanzamiento;
	
	public Director(String dni, String nombre, LocalDate fechaLanzamiento) {
		id=0;
		this.dni=dni;
		this.nombre=nombre;
		this.fechaLanzamiento=fechaLanzamiento;
	}
}
