package Unidad2.Seguimiento.Ejercicio1;
  public class NodoP<T> {
    private T valor;
    private NodoP<T> siguiente;

    public NodoP(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoP<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoP [valor=" + valor + "]";
    }
}
