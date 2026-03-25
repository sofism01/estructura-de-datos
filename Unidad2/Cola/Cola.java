public class Cola <T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamano;

    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }

    // Agrega un elemento al final de la cola
    public void agregar(T valor) {
       Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (inicio == null && fin == null && tamano == 0) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        tamano++;
    }

    // Elimina un elemento del inicio de la cola
    public T eliminar() {
        if (inicio == null) {
            throw new IllegalStateException("La cola está vacía.");
        }
        T valorEliminado = inicio.getValor();
        inicio = inicio.getSiguiente();
        tamano--;
        if (inicio == null) {
            fin = null; // Si la cola queda vacía, también se actualiza el fin
        }
        return valorEliminado;
    }

    // Esta vacía la cola
    public boolean estaVacia() {
        return tamano == 0;
    }

    // Ver inicio de la cola
    public T verInicio() {
        if (inicio == null) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return inicio.getValor();
    }
}
