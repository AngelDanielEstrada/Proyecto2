public abstract class Usuario implements IUsuario {
    private int id;
    private String nombre;
    private TokenWallet wallet;
    private HistorialViajes historial;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.wallet = new TokenWallet();
        this.historial = new HistorialViajes();
    }

    public void login() {
        // Lógica de autenticación del usuario
        System.out.println("Usuario " + nombre + " ha iniciado sesión.");
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public TokenWallet getWallet() {
        return this.wallet;
    }

    @Override
    public HistorialViajes getHistorial() {
        return this.historial;
    }

    public int getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setWallet(TokenWallet wallet) {
        this.wallet = wallet;
    }

    public void setHistorial(HistorialViajes historial) {
        this.historial = historial;
    }
}
