public class ListaSimplementeEnlazada<T> {
    private Nodo<T> cabeza;

    public ListaSimplementeEnlazada() {
        this.cabeza = null;
    }

    // Agrega un nuevo nodo al final de la lista
    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    // Agrega un nuevo nodo al inicio de la lista
    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    // Agrega en una posición específica
    public void agregarEnPosicion(T valor, int posicion) {
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa.");
        }
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (posicion == 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (actual == null) {
                throw new IllegalArgumentException("La posición excede el tamaño de la lista.");
            }
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            throw new IllegalArgumentException("La posición excede el tamaño de la lista.");
        }
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
    }

    // ELimina un nodo al final de la lista
    public void eliminarAlFinal() {
        if (cabeza == null) {
            return; // Lista vacía
        }
        if (cabeza.getSiguiente() == null) {
            cabeza = null; // Solo un nodo en la lista
            return;
        }
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(null); // Elimina el último nodo
    }

    // Elimina un nodo al inicio de la lista
    public void eliminarAlInicio() {
        if (cabeza == null) {
            return; // Lista vacía
        }
        cabeza = cabeza.getSiguiente();
    }

    // Elimina un nodo en una posición específica
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa.");
        }
        if (cabeza == null) {
            throw new IllegalArgumentException("La lista está vacía.");
        }
        if (posicion == 0) {
            cabeza = cabeza.getSiguiente();
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (actual == null || actual.getSiguiente() == null) {
                throw new IllegalArgumentException("La posición excede el tamaño de la lista.");
            }
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() == null) {
            throw new IllegalArgumentException("La posición excede el tamaño de la lista.");
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
    }

    // Busca un elemento en la lista
    public boolean buscar(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            T valorActual = actual.getValor();
            if (valorActual == null) {
                if (valor == null) {
                    return true;
                }
            } else if (valorActual.equals(valor)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Ordena la lista (asumiendo que T es Comparable)
    public void ordenar() {
        if (cabeza == null || cabeza.getSiguiente() == null) {
            return;
        }

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Nodo<T> actual = cabeza;

            while (actual.getSiguiente() != null) {
                T valorActual = actual.getValor();
                T valorSiguiente = actual.getSiguiente().getValor();

                if (comparar(valorActual, valorSiguiente) > 0) {
                    actual.setValor(valorSiguiente);
                    actual.getSiguiente().setValor(valorActual);
                    huboIntercambio = true;
                }

                actual = actual.getSiguiente();
            }
        } while (huboIntercambio);
    }

    @SuppressWarnings("unchecked")
    private int comparar(T a, T b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        if (!(a instanceof Comparable)) {
            throw new IllegalStateException("El tipo de dato debe implementar Comparable para ordenar la lista.");
        }
        return ((Comparable<T>) a).compareTo(b);
    }

    // Imprime el contenido de la lista
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getValor() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }
    
}
