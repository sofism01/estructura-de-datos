public class JuegoTurnos {
    private NodoJugador actual;
    private int cantidadJugadores;

    public JuegoTurnos() {
        this.actual = null;
        this.cantidadJugadores = 0;
    }

    public void agregarJugador(String nombre) {
        NodoJugador nuevo = new NodoJugador(nombre);

        if (actual == null) {
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            actual = nuevo;
        } else {
            NodoJugador ultimo = actual.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(actual);
            actual.setAnterior(nuevo);
        }

        cantidadJugadores++;
        System.out.println("Se unió el jugador: " + nombre);
    }

    public String jugadorActual() {
        if (actual == null) {
            return null;
        }
        return actual.getNombre();
    }

    public String pasarTurno() {
        if (actual == null) {
            System.out.println("No hay jugadores en la partida.");
            return null;
        }
        actual = actual.getSiguiente();
        System.out.println("Turno de: " + actual.getNombre());
        return actual.getNombre();
    }

    public String retrocederTurno() {
        if (actual == null) {
            System.out.println("No hay jugadores en la partida.");
            return null;
        }
        actual = actual.getAnterior();
        System.out.println("Turno de: " + actual.getNombre());
        return actual.getNombre();
    }

    public boolean expulsarJugador(String nombre) {
        if (actual == null) {
            return false;
        }

        NodoJugador cursor = actual;
        do {
            if (cursor.getNombre().equals(nombre)) {
                if (cursor.getSiguiente() == cursor) {
                    actual = null;
                } else {
                    cursor.getAnterior().setSiguiente(cursor.getSiguiente());
                    cursor.getSiguiente().setAnterior(cursor.getAnterior());
                    if (cursor == actual) {
                        actual = cursor.getSiguiente();
                    }
                }

                cantidadJugadores--;
                System.out.println("Jugador expulsado: " + nombre);
                return true;
            }
            cursor = cursor.getSiguiente();
        } while (cursor != actual);

        return false;
    }

    public String jugadorAnterior() {
        if (actual == null) {
            return null;
        }
        return actual.getAnterior().getNombre();
    }

    public String jugadorSiguiente() {
        if (actual == null) {
            return null;
        }
        return actual.getSiguiente().getNombre();
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void mostrarMesa() {
        if (actual == null) {
            System.out.println("Partida sin jugadores.");
            return;
        }

        System.out.println("Mesa de juego (circular):");
        NodoJugador cursor = actual;
        int posicion = 1;

        do {
            String marca = (cursor == actual) ? " <-- ACTUAL" : "";
            System.out.println(posicion + ". " + cursor.getNombre() + marca);
            cursor = cursor.getSiguiente();
            posicion++;
        } while (cursor != actual);

        System.out.println("Total de jugadores: " + cantidadJugadores);
    }
}
