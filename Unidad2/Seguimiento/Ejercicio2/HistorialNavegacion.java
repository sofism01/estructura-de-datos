public class HistorialNavegacion<T> {
    private NodoWeb<T> cabeza;      // Primera página visitada
    private NodoWeb<T> paginaActual; // Página que se está viendo actualmente
    private int tamaño;

    public HistorialNavegacion() {
        this.cabeza = null;
        this.paginaActual = null;
        this.tamaño = 0;
    }

    /**
     * Visitar una nueva página
     * Si ya había retrocedido, elimina todas las páginas futuras
     * @param url La URL de la nueva página a visitar
     */
    public void visitarPagina(T url) {
        NodoWeb<T> nuevaPagina = new NodoWeb<>(url);

        // Si no hay página actual, esta es la primera
        if (paginaActual == null) {
            cabeza = nuevaPagina;
            paginaActual = nuevaPagina;
        } else {
            // Eliminar todas las páginas futuras (a la derecha)
            if (paginaActual.getSiguiente() != null) {
                paginaActual.setSiguiente(null);
                System.out.println("Se eliminó el historial futuro (páginas adelante)");
            }

            // Agregar la nueva página
            paginaActual.setSiguiente(nuevaPagina);
            nuevaPagina.setAnterior(paginaActual);
            paginaActual = nuevaPagina;
        }

        tamaño++;
        System.out.println("Página visitada: " + url);
    }

    /**
     * Retroceder a la página anterior
     * @return La página anterior si existe, null en caso contrario
     */
    public T retroceder() {
        if (paginaActual == null || paginaActual.getAnterior() == null) {
            System.out.println("No hay página anterior. Estás en el inicio del historial.");
            return null;
        }

        paginaActual = paginaActual.getAnterior();
        System.out.println("Retrocediste a: " + paginaActual.getValor());
        return paginaActual.getValor();
    }

    /**
     * Avanzar a la página siguiente
     * @return La página siguiente si existe, null en caso contrario
     */
    public T avanzar() {
        if (paginaActual == null || paginaActual.getSiguiente() == null) {
            System.out.println("No hay página siguiente. Estás al final del historial.");
            return null;
        }

        paginaActual = paginaActual.getSiguiente();
        System.out.println("Avanzaste a: " + paginaActual.getValor());
        return paginaActual.getValor();
    }

    /**
     * Obtener la página actual
     * @return La URL de la página actual
     */
    public T getPaginaActual() {
        if (paginaActual == null) {
            System.out.println("No hay página actual.");
            return null;
        }
        System.out.println("Página actual: " + paginaActual.getValor());
        return paginaActual.getValor();
    }

    /**
     * Eliminar una página específica del historial
     * @param url La URL de la página a eliminar
     */
    public void eliminarPagina(T url) {
        if (cabeza == null) {
            System.out.println("El historial está vacío.");
            return;
        }

        // Buscar la página a eliminar
        NodoWeb<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(url)) {
                // Si es la página actual, mover a la siguiente o anterior
                if (actual == paginaActual) {
                    if (actual.getSiguiente() != null) {
                        paginaActual = actual.getSiguiente();
                    } else if (actual.getAnterior() != null) {
                        paginaActual = actual.getAnterior();
                    } else {
                        paginaActual = null;
                    }
                    System.out.println("Página actual eliminada. Moviéndote a otra página.");
                }

                // Desconectar la página
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente();
                }

                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }

                tamaño--;
                System.out.println("Página eliminada: " + url);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("La página " + url + " no se encontró en el historial.");
    }

    /**
     * Mostrar todo el historial de navegación
     */
    public void mostrarHistorial() {
        if (cabeza == null) {
            System.out.println("El historial está vacío.");
            return;
        }

        System.out.println("\n=== Historial de Navegación ===");
        NodoWeb<T> actual = cabeza;
        int posicion = 1;

        while (actual != null) {
            String marcador = (actual == paginaActual) ? " <-- ACTUAL" : "";
            System.out.println(posicion + ". " + actual.getValor() + marcador);
            actual = actual.getSiguiente();
            posicion++;
        }

        System.out.println("Total de páginas en historial: " + tamaño);
    }

    /**
     * Mostrar el historial hacia atrás desde la página actual
     */
    public void mostrarHistorialHaciaAtras() {
        if (paginaActual == null) {
            System.out.println("No hay página actual.");
            return;
        }

        System.out.println("\n=== Historial hacia atrás desde la página actual ===");
        NodoWeb<T> actual = paginaActual;
        int posicion = 1;

        while (actual != null) {
            String marcador = (actual == paginaActual) ? " <-- ACTUAL" : "";
            System.out.println(posicion + ". " + actual.getValor() + marcador);
            actual = actual.getAnterior();
            posicion++;
        }
    }

    /**
     * Mostrar el historial hacia adelante desde la página actual
     */
    public void mostrarHistorialHaciaAdelante() {
        if (paginaActual == null) {
            System.out.println("No hay página actual.");
            return;
        }

        System.out.println("\n=== Historial hacia adelante desde la página actual ===");
        NodoWeb<T> actual = paginaActual;
        int posicion = 1;

        while (actual != null) {
            String marcador = (actual == paginaActual) ? " <-- ACTUAL" : "";
            System.out.println(posicion + ". " + actual.getValor() + marcador);
            actual = actual.getSiguiente();
            posicion++;
        }
    }

    /**
     * Verificar si el historial está vacío
     * @return true si está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return cabeza == null;
    }

    /**
     * Obtener el tamaño actual del historial
     * @return Número de páginas en el historial
     */
    public int getTamaño() {
        return tamaño;
    }
}

