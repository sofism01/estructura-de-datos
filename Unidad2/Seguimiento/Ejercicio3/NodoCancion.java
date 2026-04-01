public class NodoCancion {
    private String titulo;
    private NodoCancion siguiente;

    public NodoCancion(String titulo) {
        this.titulo = titulo;
        this.siguiente = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public NodoCancion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCancion siguiente) {
        this.siguiente = siguiente;
    }
}
