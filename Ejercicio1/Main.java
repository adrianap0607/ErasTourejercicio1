import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Localidad localidad1 = new Localidad(1, 100, 20);
        Localidad localidad5 = new Localidad(5, 500, 20);
        Localidad localidad10 = new Localidad(10, 1000, 20);
        Comprador comprador = new Comprador("", "", 0, 0);

        boolean running = true;
        while (running) {
            System.out.println("\nMenú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    comprador = nuevoComprador(scanner);
                    break;
                case 2:
                    nuevaSolicitudBoletos(scanner, comprador, localidad1, localidad5, localidad10);
                    break;
                case 3:
                    consultarDisponibilidadTotal(localidad1, localidad5, localidad10);
                    break;
                case 4:
                    consultarDisponibilidadIndividual(scanner, localidad1, localidad5, localidad10);
                    break;
                case 5:
                    reporteDeCaja(localidad1, localidad5, localidad10);
                    break;
                case 6:
                    running = false;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }

        System.out.println("¡Gracias por adquirir sus boletos con nosotros!");
        scanner.close();
    }

    public static Comprador nuevoComprador(Scanner scanner) {
        // Implementar la lógica para crear un nuevo comprador con los datos ingresados por el usuario
        System.out.println("Ingrese el nombre del comprador:");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el email del comprador:");
        String email = scanner.nextLine();

        System.out.println("Ingrese la cantidad de boletos que desea comprar:");
        int numBoletos = scanner.nextInt();

        System.out.println("Ingrese el presupuesto del comprador:");
        int presupuesto = scanner.nextInt();

        return new Comprador(nombre, email, numBoletos, presupuesto);
    }

    public static void nuevaSolicitudBoletos(Scanner scanner, Comprador comprador, Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        // Se implementa la lógica para crear una solicitud de boletos para el comprador en una localidad
        System.out.println("Ingrese el número del ticket:");
        int ticketNumber = scanner.nextInt();

        Ticket ticket = new Ticket(ticketNumber);

        if (ticket.isValid(localidad1, localidad5, localidad10)) {
            Localidad selectedLocation = ticket.selectRandomLocation(localidad1, localidad5, localidad10);

            if (selectedLocation != null) {
                System.out.println("Ticket válido. Seleccionado para la Localidad " + selectedLocation.getNumber());

                System.out.println("Ingrese la cantidad de boletos que desea comprar:");
                int numBoletos = scanner.nextInt();

                if (selectedLocation.hasAvailability(numBoletos)) {
                    if (selectedLocation.isAffordable(comprador.getPresupuesto())) {
                        selectedLocation.setAvailability(selectedLocation.getAvailability() - numBoletos);
                        comprador.setNumBoletos(comprador.getNumBoletos() + numBoletos);
                        comprador.setPresupuesto(comprador.getPresupuesto() - (numBoletos * selectedLocation.getPrice()));
                        System.out.println("¡Compra exitosa!");
                    } else {
                        System.out.println("El precio de la localidad excede el presupuesto del comprador.");
                    }
                } else {
                    System.out.println("No hay suficiente disponibilidad en la localidad seleccionada.");
                }
            } else {
                System.out.println("No hay disponibilidad en ninguna localidad para el ticket.");
            }
        } else {
            System.out.println("El ticket no es válido para comprar boletos.");
        }
    }

    public static void consultarDisponibilidadTotal(Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        // Código para mostrar la disponibilidad total de boletos en cada localidad
        System.out.println("Disponibilidad total:");
        System.out.println("Localidad 1: " + localidad1.getAvailability() + " boletos disponibles");
        System.out.println("Localidad 5: " + localidad5.getAvailability() + " boletos disponibles");
        System.out.println("Localidad 10: " + localidad10.getAvailability() + " boletos disponibles");
    }

    public static void consultarDisponibilidadIndividual(Scanner scanner, Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        // Código para mostrar la disponibilidad individual de boletos en una localidad seleccionada
        System.out.println("Ingrese el número de la localidad (1, 5 o 10):");
        int localidadNumber = scanner.nextInt();
        Localidad selectedLocation = null;

        switch (localidadNumber) {
            case 1:
                selectedLocation = localidad1;
                break;
            case 5:
                selectedLocation = localidad5;
                break;
            case 10:
                selectedLocation = localidad10;
                break;
            default:
                System.out.println("Localidad no válida.");
                return;
        }

        System.out.println("Disponibilidad de la Localidad " + selectedLocation.getNumber() + ": " + selectedLocation.getAvailability() + " boletos disponibles");
    }

    public static void reporteDeCaja(Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        // Código para mostrar el reporte de caja basado en los boletos vendidos en cada localidad
        int totalIngresos = (localidad1.getCapacity() - localidad1.getAvailability()) * localidad1.getPrice()
            + (localidad5.getCapacity() - localidad5.getAvailability()) * localidad5.getPrice()
            + (localidad10.getCapacity() - localidad10.getAvailability()) * localidad10.getPrice();

        System.out.println("Reporte de caja:");
        System.out.println("Ingresos totales: $" + totalIngresos);
    }
}
