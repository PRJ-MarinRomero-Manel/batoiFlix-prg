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
    public Valoracion() {}

    public Produccion getProduccion() {
        return produccion;
    }

    public double getNota() {
        return nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public int getUsuarioId() {
        return (usuario != null) ? usuario.getId() : -1;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

