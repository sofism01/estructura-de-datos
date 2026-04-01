public class NodoWeb<T> {
    private T valor;
    private NodoWeb<T> siguiente;
    private NodoWeb<T> anterior;

    public NodoWeb(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoWeb<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoWeb<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoWeb<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoWeb<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NodoWeb [valor=" + valor + "]";
    }
}
