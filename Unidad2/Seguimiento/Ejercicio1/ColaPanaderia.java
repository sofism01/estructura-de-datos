package Unidad2.Seguimiento.Ejercicio1;
public class ColaPanaderia<T> {
    private NodoP<T> frente;  // Primer cliente en la cola
    private NodoP<T> finalCola;  // Último cliente en la cola
    private int tamaño;

    public ColaPanaderia() {
        this.frente = null;
        this.finalCola = null;
        this.tamaño = 0;
    }

    // Agregar un cliente al final de la cola
    public void agregar(T cliente) {
        NodoP<T> nuevoNodo = new NodoP<>(cliente);

        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        tamaño++;
        System.out.println("Cliente " + cliente + " agregado al final de la cola. Turno asignado.");
    }

    // Eliminar un cliente del frente de la cola (atender al siguiente cliente)
    public T eliminar() {
        if (estaVacia()) {
            System.out.println("No hay clientes en espera.");
            return null;
        }

        T clienteAtendido = frente.getValor();
        frente = frente.getSiguiente();

        if (frente == null) {
            finalCola = null;  // Cola quedó vacía
        }

        tamaño--;
        System.out.println("Cliente " + clienteAtendido + " atendido y eliminado de la cola.");
        return clienteAtendido;
    }

    // Buscar un cliente específico en la cola
    public boolean buscar(T cliente) {
        NodoP<T> actual = frente;
        while (actual != null) {
            if (actual.getValor().equals(cliente)) {
                System.out.println("Cliente " + cliente + " encontrado en la cola.");
                return true;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Cliente " + cliente + " no encontrado en la cola.");
        return false;
    }

    // Mostrar todos los clientes en la cola
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No hay clientes en espera.");
            return;
        }

        System.out.println("=== Lista de turnos en la panadería ===");
        NodoP<T> actual = frente;
        int posicion = 1;
        while (actual != null) {
            System.out.println("Turno " + posicion + ": " + actual.getValor());
            actual = actual.getSiguiente();
            posicion++;
        }
        System.out.println("Total de clientes en espera: " + tamaño);
    }

    // Obtener el siguiente cliente a atender sin eliminarlo de la cola
    public T siguienteCliente() {
        if (estaVacia()) {
            System.out.println("No hay clientes en espera.");
            return null;
        }
        System.out.println("Siguiente cliente a atender: " + frente.getValor());
        return frente.getValor();
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Obtener el tamaño de la cola
    public int getTamaño() {
        return tamaño;
    }
}
