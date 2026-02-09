import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static Object[][] prestamos = new Object[100][100];
    static Scanner sc = new Scanner(System.in);
    static int filas = 0; // cantidad de préstamos registrados

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: registrarPrestamo(); break;
                case 2: mostrarPrestamos(); break;
                case 3: buscarPrestamoPorId(); break;
                case 4: actualizarPrestamo(); break;
                case 5: eliminarPrestamo(); break;
                case 6: calcularTotalMultas(); break;
                case 7: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida."); break;
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD (por implementar) ======

    static void eliminarPrestamo() { 
        int idEliminar = leerEntero("Ingrese el ID a eliminar: ");
        for (int i = 0; i < filas; i++) {
            if ((int) prestamos[i][0] == idEliminar) {
                for (int j = i; j < filas - 1; j++) {
                    prestamos[j] = prestamos[j + 1];
                }
                filas--;
                System.out.println("Préstamo eliminado.");
                return;
            }
        }
    }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { 
        float total = 0;
        for (int i = 0; i < filas; i++) {
            int dias = (int) prestamos[i][3];
            int multaDia = (int) prestamos[i][4];
            total += dias * multaDia;
        }
        System.out.println("Total de multas: $" + total);
    }
    // ====== Utilidades ======
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}