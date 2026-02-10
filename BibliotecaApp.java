import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static Object[][] prestamos = new Object[100][5];
    static Scanner sc = new Scanner(System.in);
    static int filas = 0;

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

    // ================= CRUD =================

    static void registrarPrestamo() {
        if (filas >= prestamos.length) {
            System.out.println("No hay espacio para más préstamos.");
            return;
        }

        int id = leerEntero("ID del préstamo: ");

        // Validar ID duplicado
        for (int i = 0; i < filas; i++) {
            if ((int) prestamos[i][0] == id) {
                System.out.println("Error: ya existe un préstamo con ese ID.");
                return;
            }
        }

        prestamos[filas][0] = id;
        prestamos[filas][1] = leerTexto("Nombre del usuario: ");
        prestamos[filas][2] = leerTexto("Título del libro: ");
        prestamos[filas][3] = leerEntero("Días de préstamo: ");
        prestamos[filas][4] = leerEntero("Multa por día: ");

        filas++;
        System.out.println("Préstamo registrado correctamente.");
    }

    static void mostrarPrestamos() {
        if (filas == 0) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (int i = 0; i < filas; i++) {
            System.out.println("\nID PRESTAMO: " + prestamos[i][0]);
            System.out.println("NOMBRE USUARIO: " + prestamos[i][1]);
            System.out.println("TÍTULO LIBRO: " + prestamos[i][2]);
            System.out.println("DÍAS PRÉSTAMO: " + prestamos[i][3]);
            System.out.println("MULTA POR DÍA: " + prestamos[i][4]);
        }
    }

    static void buscarPrestamoPorId() {
        int id = leerEntero("Ingrese el ID a buscar: ");

        for (int i = 0; i < filas; i++) {
            if ((int) prestamos[i][0] == id) {
                System.out.println(
                    "ID: " + prestamos[i][0] +
                    ", Usuario: " + prestamos[i][1] +
                    ", Libro: " + prestamos[i][2] +
                    ", Días: " + prestamos[i][3] +
                    ", Multa/día: " + prestamos[i][4]
                );
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void actualizarPrestamo() {
        int id = leerEntero("Ingrese el ID a actualizar: ");

        for (int i = 0; i < filas; i++) {
            if ((int) prestamos[i][0] == id) {
                prestamos[i][1] = leerTexto("Nuevo nombre de usuario: ");
                prestamos[i][2] = leerTexto("Nuevo título del libro: ");
                prestamos[i][3] = leerEntero("Nuevos días de préstamo: ");
                prestamos[i][4] = leerEntero("Nueva multa por día: ");
                System.out.println("Préstamo actualizado.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void eliminarPrestamo() {
        int idEliminar = leerEntero("Ingrese el ID a eliminar: ");

        for (int i = 0; i < filas; i++) {
            if ((int) prestamos[i][0] == idEliminar) {

                for (int j = i; j < filas - 1; j++) {
                    for (int k = 0; k < 5; k++) {
                        prestamos[j][k] = prestamos[j + 1][k];
                    }
                }

                filas--;
                System.out.println("Préstamo eliminado.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void calcularTotalMultas() {
        int total = 0;

        for (int i = 0; i < filas; i++) {
            int dias = (int) prestamos[i][3];
            int multaDia = (int) prestamos[i][4];
            total += dias * multaDia;
        }

        System.out.println("Total de multas: $" + total);
    }

    // ================= UTILIDADES =================

    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
