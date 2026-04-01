package Unidad2.Seguimiento.Ejercicio1;
public class Main {
    public static void main(String[] args) {
        ColaPanaderia<String> colaPanaderia = new ColaPanaderia<>();

        System.out.println("Sistema de Turnos - Panadería");

        // Simular llegada de clientes
        System.out.println("Llegada de clientes: ");
        colaPanaderia.agregar("María García");
        colaPanaderia.agregar("Juan Pérez");
        colaPanaderia.agregar("Ana López");
        colaPanaderia.agregar("Carlos Rodríguez");

        // Mostrar cola actual
        System.out.println("Lista de turnos actual");
        colaPanaderia.mostrar();

        // Consultar siguiente cliente
        System.out.println("Consulta de siguiente cliente");
        colaPanaderia.siguienteCliente();

        // Buscar cliente específico
        System.out.println("Búsqueda de cliente");
        colaPanaderia.buscar("Ana López");
        colaPanaderia.buscar("Pedro Martínez");

        // Atender clientes
        System.out.println("Atención de clientes");
        colaPanaderia.eliminar();  // Atender a María
        colaPanaderia.eliminar();  // Atender a Juan

        // Mostrar cola después de atender
        System.out.println("Lista de turnos después de atender");
        colaPanaderia.mostrar();

        // Agregar más clientes
        System.out.println("Llegada de nuevos clientes");
        colaPanaderia.agregar("Sofia Martínez");
        colaPanaderia.agregar("Diego Sánchez");

        // Mostrar cola final
        System.out.println("Lista de turnos final");
        colaPanaderia.mostrar();
    }
}