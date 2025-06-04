package interfaces;

import modelo.TokenWallet;
import modelo.HistorialViajes;

public interface IUsuario {
    String getNombre();
    TokenWallet getWallet();
    HistorialViajes getHistorial();
}
