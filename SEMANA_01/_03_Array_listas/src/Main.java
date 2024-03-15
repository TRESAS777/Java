import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /* 1. Calculadora de Promedios: Escribe un programa que utilice un array de tipo
    double para almacenar las calificaciones finales de 10 estudiantes en un curso. El
    programa debe calcular y mostrar el promedio de estas calificaciones.*/
        //Creamos nuestro objeto scanner
        Scanner objScanner = new Scanner(System.in);

        //Creamos el array que guardara las notas del estudiante
        double[] notas = new double[10];

        //Variable para guardar la suma total
        double sumaTotal = 0;

        //ciclo for para pedir al usuario las notas de los 10 estudiantes
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Ingrese la nota del estudiante #"+(i+1));
            try {
                notas[i] = objScanner.nextDouble();
                sumaTotal += notas[i];
            } catch (Exception e) {
                System.out.println("Nota no valida");
                break;
            }
        }

        //variable para guardar el promedio
        double promedio = sumaTotal / notas.length;
        System.out.println("El promedio de todas las notas es: " + promedio);

    }
}