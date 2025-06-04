package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private int id;
    private String nombre;
    private List<String> paradas;
    private List<Comentario> comentarios;

    // Constructor
    public Ruta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para gestionar paradas
    public void agregarParada(String parada) {
        if (parada != null && !parada.isEmpty()) {
            paradas.add(parada);
        }
    }

    public boolean eliminarParada(String parada) {
        return paradas.remove(parada);
    }

    public List<String> getParadas() {
        return new ArrayList<>(paradas); // Devuelve copia para proteger encapsulamiento
    }

    // Métodos para gestionar comentarios
    public void agregarComentario(Comentario comentario) {
        if (comentario != null) {
            comentarios.add(comentario);
        }
    }

    public List<Comentario> getComentarios() {
        return new ArrayList<>(comentarios); // Devuelve copia
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", paradas=" + paradas +
                '}';
    }
}