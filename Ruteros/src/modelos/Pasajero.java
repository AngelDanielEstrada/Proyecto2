package modelo;

import java.util.Date;

public class Pasajero extends Usuario {

    public Pasajero(int id, String nombre) {
        super(id, nombre);
    }

    /**
     * Método para ganar tokens, suma al saldo de su wallet.
     */
    public void ganarTokens(int cantidad) {
        if (cantidad > 0) {
            getWallet().recargar(cantidad);
            System.out.println(getNombre() + " ganó " + cantidad + " tokens.");
        }
    }

    /**
     * Método para comentar una ruta.
     */
    public void comentarRuta(Ruta ruta, String comentario) {
        if (ruta != null && comentario != null && !comentario.trim().isEmpty()) {
            Comentario nuevoComentario = new Comentario(this, comentario, new Date());
            ruta.agregarComentario(nuevoComentario);
            System.out.println(getNombre() + " comentó en la ruta: " + comentario);
        }
    }
}
