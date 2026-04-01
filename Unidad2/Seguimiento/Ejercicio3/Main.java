public class Main {
    public static void main(String[] args) {
        ListaCircularCanciones reproductor = new ListaCircularCanciones();

        System.out.println("APP DE MÚSICA");

        System.out.println("Reproducción continua");
        reproductor.agregarCancion("Bohemian Rhapsody");
        reproductor.agregarCancion("Viva La Vida");
        reproductor.agregarCancion("Billie Jean");
        reproductor.mostrarSecuencia();

        System.out.println("Reproducción de 6 avances:");
        for (int i = 0; i < 6; i++) {
            reproductor.siguienteCancion();
        }

        System.out.println("Eliminar una canción en ejecución");
        boolean eliminada = reproductor.eliminarCancion("Viva La Vida");
        System.out.println("¿Se eliminó? " + eliminada);
        reproductor.mostrarSecuencia();

        System.out.println("Continuidad tras eliminación");
        for (int i = 0; i < 5; i++) {
            reproductor.siguienteCancion();
        }

        System.out.println("Tamaño final de la secuencia: " + reproductor.getTamanio());
    }
}
