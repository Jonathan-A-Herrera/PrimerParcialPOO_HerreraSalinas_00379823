import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Articulo> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Sistema de gestión de ElectroMart");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Modificar Artículo");
            System.out.println("3. Consultar Listado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    modificarArticulo();
                    break;
                case 3:
                    consultarListado();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione una opción válida.");
            }
        }
        System.out.println("Saliendo del sistema de gestión...");
    }

    private static void agregarArticulo() {
        System.out.println("Seleccione el tipo de artículo (1: Celular, 2: Laptop): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el nombre del artículo: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el procesador del artículo: ");
        String procesador = scanner.nextLine();

        System.out.println("Ingrese la descripción del artículo: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio del artículo: ");
        double precio = Double.parseDouble(scanner.nextLine());

        if (tipo == 1) {
            inventario.add(new Celular(nombre, procesador, descripcion, precio));
            System.out.println("Celular agregado correctamente.");
        } else if (tipo == 2) {
            inventario.add(new Laptop(nombre, procesador, descripcion, precio));
            System.out.println("Laptop agregada correctamente.");
        } else {
            System.out.println("Tipo de artículo no válido.");
        }
    }

    private static void modificarArticulo() {
        System.out.println("Ingrese el nombre del artículo que desea modificar: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Articulo articulo : inventario) {
            if (articulo.obtenerNombre().equals(nombre)) {
                encontrado = true;
                System.out.println("Ingrese el nuevo nombre del artículo: ");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingrese el nuevo procesador del artículo: ");
                String nuevoProcesador = scanner.nextLine();
                System.out.println("Ingrese la nueva descripción del artículo: ");
                String nuevaDescripcion = scanner.nextLine();
                System.out.println("Ingrese el nuevo precio del artículo: ");
                double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                articulo.setNombre(nuevoNombre);
                articulo.setDescripcion(nuevaDescripcion);
                articulo.setPrecio(nuevoPrecio);

                if (articulo instanceof Celular) {
                    ((Celular) articulo).setProcesador(nuevoProcesador);
                } else if (articulo instanceof Laptop) {
                    ((Laptop) articulo).setProcesador(nuevoProcesador);
                }

                System.out.println("Artículo modificado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void consultarListado() {
        System.out.println("Listado de Artículos en ElectroMart:");
        for (Articulo articulo : inventario) {
            System.out.println("Nombre: " + articulo.obtenerNombre());
            if (articulo instanceof Celular) {
                System.out.println("Tipo: Celular");
                System.out.println("Procesador: " + ((Celular) articulo).obtenerProcesador());
            } else if (articulo instanceof Laptop) {
                System.out.println("Tipo: Laptop");
                System.out.println("Procesador: " + ((Laptop) articulo).obtenerProcesador());
            }
            System.out.println("Descripción: " + articulo.obtenerDescripcion());
            System.out.println("Precio: $" + articulo.obtenerPrecio());
            System.out.println();
        }
    }
}

