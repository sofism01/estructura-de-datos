public class NodoJugador {
    private String nombre;
    private NodoJugador siguiente;
    private NodoJugador anterior;

    public NodoJugador(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }

    public NodoJugador getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoJugador anterior) {
        this.anterior = anterior;
    }
}
