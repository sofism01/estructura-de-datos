public class ListaCircularCanciones {
    private NodoCancion actual;
    private int tamanio;

    public ListaCircularCanciones() {
        this.actual = null;
        this.tamanio = 0;
    }

    public void agregarCancion(String titulo) {
        NodoCancion nuevo = new NodoCancion(titulo);

        if (actual == null) {
            actual = nuevo;
            nuevo.setSiguiente(nuevo);
        } else {
            NodoCancion ultimo = obtenerUltimo();
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(actual);
        }

        tamanio++;
        System.out.println("Canción agregada: " + titulo);
    }

    public String cancionActual() {
        if (actual == null) {
            return null;
        }
        return actual.getTitulo();
    }

    public String siguienteCancion() {
        if (actual == null) {
            System.out.println("No hay canciones para reproducir.");
            return null;
        }

        actual = actual.getSiguiente();
        System.out.println("Reproduciendo: " + actual.getTitulo());
        return actual.getTitulo();
    }

    public boolean eliminarCancion(String titulo) {
        if (actual == null) {
            return false;
        }

        NodoCancion anterior = obtenerUltimo();
        NodoCancion cursor = actual;

        do {
            if (cursor.getTitulo().equals(titulo)) {
                if (cursor == actual && cursor.getSiguiente() == actual) {
                    actual = null;
                } else {
                    anterior.setSiguiente(cursor.getSiguiente());
                    if (cursor == actual) {
                        actual = cursor.getSiguiente();
                    }
                }

                tamanio--;
                System.out.println("Canción eliminada: " + titulo);
                return true;
            }

            anterior = cursor;
            cursor = cursor.getSiguiente();
        } while (cursor != actual);

        return false;
    }

    public void mostrarSecuencia() {
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCancion cursor = actual;
        int posicion = 1;

        System.out.println("Secuencia circular actual:");
        do {
            System.out.println(posicion + ". " + cursor.getTitulo());
            cursor = cursor.getSiguiente();
            posicion++;
        } while (cursor != actual);
    }

    public int getTamanio() {
        return tamanio;
    }

    private NodoCancion obtenerUltimo() {
        NodoCancion cursor = actual;
        while (cursor.getSiguiente() != actual) {
            cursor = cursor.getSiguiente();
        }
        return cursor;
    }
}
