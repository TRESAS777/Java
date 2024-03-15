import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {
    /* 2. Buscador de Número Mayor y Menor: Utiliza un array de int para almacenar 5
    números enteros ingresados por el usuario (puedes usar la clase Scanner para la entrada de
    datos). El programa debe encontrar y mostrar el número mayor y el menor de la lista.
     */

        Scanner objScan = new Scanner(System.in);

        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingresa 5 números enteros: #"+1);
            numeros[i] = objScan.nextInt();
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int numero : numeros){
            if (numero > mayor){
                mayor = numero;
            }
            if (numero < menor){
                menor = numero;
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);

    }
}
