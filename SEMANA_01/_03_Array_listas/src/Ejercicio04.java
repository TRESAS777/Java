import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
    /* 4. Planificador de Viajes: Escribe un programa para ayudar a planificar viajes por
    carretera. Los usuarios pueden ingresar varias ciudades que planean visitar en
    orden. Utiliza un arreglo de String para almacenar las ciudades. El programa debe
    ser capaz de:
     Añadir y remover ciudades del itinerario.
     Mostrar la lista completa de ciudades a visitar.
     (Opcional) Calcular la distancia total del viaje asumiendo distancias ficticias entre
    ciudades consecutivas.*/

        ArrayList<String> ciudades = new ArrayList<>();
        Scanner objScan = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nENTER PARA CONTINUAR...");
            objScan.nextLine();
            System.out.println("""
                    Planificador de viajes
                    1. Añadir ciudad al itinerario
                    2. Remover ciudad del itinerario
                    3. Mostrar itinerario
                    4. Calcular distancia total del viaje
                    5. Salir
                    
                    Seleccione una opcion: 
                    """);
            option = objScan.nextInt();

            switch (option){
                case 1:
                    System.out.println("Ingrese el nombre de la cuidad: ");
                    String ciudadAgregar = objScan.next();
                    ciudades.add(ciudadAgregar);
                    break;
                case 2:
                    System.out.println("¿Cúal es el nombre de la ciudad a eliminar?");
                    String ciudadEliminar = objScan.next();
                    if (ciudades.remove(ciudadEliminar)){
                        System.out.println(ciudadEliminar + " ha sido eliminada.");
                    } else {
                        System.out.println(ciudadEliminar + " no se ha encontrado en el itinerario.");
                    }
                    break;
                case 3:
                    System.out.println("Itineario de viaje:");
                    for (String ciudad : ciudades){
                        System.out.println(ciudad);
                    }
                    break;
                case 4:
                    int distanciaTotal = (ciudades.size()-1)*100;
                    System.out.println("Distancia estimada del viaje: " + distanciaTotal + " Km");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (option != 5);
    }
}
