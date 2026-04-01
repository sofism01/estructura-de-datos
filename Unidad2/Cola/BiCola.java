package Unidad2.Cola;

public class BiCola {
    private Nodo<String> inicio;
    private Nodo<String> fin;

    public BiCola() {
        this.inicio = null;
        this.fin = null;
    }

    // Agrega un elemento al inicio de la bi-cola
    public void agregarInicio(String valor) {
        Nodo<String> nuevoNodo = new Nodo<>(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
    }

    // Agrega un elemento al final de la bi-cola
    public void agregarFinal(String valor) {
        Nodo<String> nuevoNodo = new Nodo<>(valor);
        if (fin == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    // Elimina un elemento del inicio de la bi-cola
    public String eliminarInicio() {
        if (inicio == null) {
            return null; // Cola vacía
        }
        String valor = inicio.getValor();
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            fin = null; // Si la cola queda vacía, también se actualiza el fin
        }
        return valor;
    }

    // Elimina un elemento del final de la bi-cola
    public String eliminarFinal() {
        if (fin == null) {
            return null; // Cola vacía
        }
        String valor = fin.getValor();
        if (inicio == fin) { // Solo hay un elemento
            inicio = null;
            fin = null;
        } else {
            Nodo<String> actual = inicio;
            while (actual.getSiguiente() != fin) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
            fin = actual;
        }
        return valor;
    }
    
}
