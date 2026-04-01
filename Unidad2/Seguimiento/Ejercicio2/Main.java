public class Main {
    public static void main(String[] args) {
        HistorialNavegacion<String> historial = new HistorialNavegacion<>();

        System.out.println("Sistema de Historial de Navegación Web");

        // Visitar páginas
        System.out.println("Visitando páginas");
        historial.visitarPagina("https://www.google.com");
        historial.visitarPagina("https://www.youtube.com");
        historial.visitarPagina("https://www.github.com");
        historial.visitarPagina("https://www.stackoverflow.com");

        // Mostrar historial completo
        historial.mostrarHistorial();

        // Consultar página actual
        System.out.println("Página actual");
        historial.getPaginaActual();

        // Retroceder
        System.out.println("Retroceder");
        historial.retroceder();
        historial.retroceder();
        historial.mostrarHistorial();

        // Mostrar historial hacia adelante desde la posición actual
        System.out.println("Historial hacia adelante");
        historial.mostrarHistorialHaciaAdelante();

        // Avanzar
        System.out.println("Avanzar");
        historial.avanzar();
        historial.mostrarHistorial();

        // Visitar nueva página (esto elimina el historial futuro)
        System.out.println("Visitar nueva página después de retroceder");
        historial.visitarPagina("https://www.wikipedia.org");
        historial.mostrarHistorial();

    

        // Más pruebas
        System.out.println("Más navegación");
        historial.retroceder();
        historial.retroceder();
        historial.mostrarHistorial();
        System.out.println();
        historial.mostrarHistorialHaciaAtras();

        // Intentar retroceder al inicio
        System.out.println("Intentar retroceder al inicio");
        historial.retroceder();
        historial.retroceder();
        historial.retroceder();

    }
}