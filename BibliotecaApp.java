import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static Object[][] prestamos = new Object[10][5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                case 6 -> calcularTotalMultas();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
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
    static void registrarPrestamo() { /* TODO */ }
    static void mostrarPrestamos() { /* TODO */ }
    static void buscarPrestamoPorId() { /* TODO */ }
    static void actualizarPrestamo() { /* TODO */ }
    static void eliminarPrestamo() { 
        int i, j;
        int id_eliminarPrestamo;
        id_eliminarPrestamo = sc.nextInt();
        for (i = 0; i < filas; i++){
            if(prestamo[i][1] = id_eliminarPrestamo){
                prestamos[i][1] = prestamos[i+1][1];
            }
        }
     }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { 
        float calculo[] = new float[n];
        for(int i = 0; i < filas; i++){
            float calculos = prestamos[i][4] * prestamos[i][5];
            calculo[i] = calculos;
        }
        for(int i = 0; i < filas; i++){
            System.out.printn(calculo[i]);
        }
     }

     

    // ====== Utilidades mínimas ======
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

