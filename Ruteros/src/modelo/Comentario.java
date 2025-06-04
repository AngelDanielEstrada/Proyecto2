package modelo;

import java.util.Date;

public class Comentario {
    private Pasajero usuario;
    private String contenido;
    private Date fecha;

    public Comentario(Pasajero usuario, String contenido) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.fecha = new Date(); // Fecha actual automáticamente
    }

    // Getters
    public Pasajero getUsuario() {
        return usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "usuario=" + usuario.getNombre() +
                ", contenido='" + contenido + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}