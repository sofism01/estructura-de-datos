public class Main {
    public static void main(String[] args) {
        JuegoTurnos partida = new JuegoTurnos();

        System.out.println("JUEGO POR TURNOS");

        partida.agregarJugador("Sofia");
        partida.agregarJugador("Lucas");
        partida.agregarJugador("Valentina");
        partida.agregarJugador("Mateo");

        System.out.println("Estado inicial:");
        partida.mostrarMesa();
        System.out.println("Jugador actual: " + partida.jugadorActual());
        System.out.println("Jugó antes: " + partida.jugadorAnterior());
        System.out.println("Juega después: " + partida.jugadorSiguiente());

        System.out.println("Pasar turnos hacia adelante:");
        partida.pasarTurno();
        partida.pasarTurno();

        System.out.println("Mover turnos hacia atrás:");
        partida.retrocederTurno();

        System.out.println("Expulsar jugador en mitad de la partida (Valentina):");
        boolean expulsado = partida.expulsarJugador("Valentina");
        System.out.println("¿Se expulsó? " + expulsado);
        partida.mostrarMesa();

        System.out.println("Comprobar continuidad del ciclo:");
        for (int i = 0; i < 6; i++) {
            partida.pasarTurno();
        }

        System.out.println("Jugador actual: " + partida.jugadorActual());
        System.out.println("Jugó antes: " + partida.jugadorAnterior());
        System.out.println("Juega después: " + partida.jugadorSiguiente());

    }
}
