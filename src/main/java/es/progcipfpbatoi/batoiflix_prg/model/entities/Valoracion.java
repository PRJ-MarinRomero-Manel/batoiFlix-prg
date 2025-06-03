package es.progcipfpbatoi.batoiflix_prg.model.entities;

public class Valoracion {
	private Produccion produccion;
	private double nota;
	private Usuario usuario;
	private String mensaje;
	
	public Valoracion(Produccion produccion, double nota, Usuario usuario, String mensaje) {
		this.produccion = produccion;
		this.nota = nota;
		this.usuario = usuario;
		this.mensaje = mensaje;
	}

	public double getNota() {
		return nota;
	}

}
