import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args){
    /* 3. Sistema de Reservas: Desarrolla un programa para un teatro para gestionar las
    reservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un
    arreglo bidimensional de boolean donde true representa un asiento ocupado y false
    uno disponible. El sistema debe permitir:
     Reservar y cancelar asientos.
     Mostrar los asientos disponibles.
     Contabilizar el total de asientos ocupados y disponibles.*/

        //creamos la matriz que nos permitirá guardar el estado de todos los asientos
        boolean[][] listaAsientos = new boolean[5][10];

        //objeto escanear para obtener información por consola
        Scanner objScanner = new Scanner(System.in);

        //Variable para guardar la opcion del usuario
        int opcion = 0;

        //Imprimir en consola una linea o salto de linea


        do {
            try {
                System.out.println("PRESIONE ENTER PARA CONTINUAR");
                objScanner.nextLine();
                System.out.println("------ RESERVA DE PUESTOS TEATRO ------");
                System.out.println("1. Reservar asiento.");
                System.out.println("2. Cancelar asiento.");
                System.out.println("3. Mostrar asientos disponibles.");
                System.out.println("4. Contabilizar asientos disponibles y ocupados.");
                System.out.println("5. Salir.");
                System.out.println("Ingrese una opcion.");
                opcion = objScanner.nextInt();

                //Leemos la opcion elegida por el usuario
                if (opcion <= 0 || opcion > 5 ){
                    System.out.println("Ingresa valores dentro del rango de opciones.\n");
                } else {
                    int fila, asiento;
                    switch (opcion){
                        case 1:
                            System.out.println("Ingrese fila (1-5)");
                            fila = objScanner.nextInt() - 1;
                            System.out.println("Ingrese el asiento (1-10)");
                            asiento = objScanner.nextInt() - 1;
                            if (fila <0 || fila > 5 || asiento < 0 || asiento > 10){
                                System.out.println("Ingresa valores dentro del rango de opciones.\n");
                            } else {
                                if (!listaAsientos[fila][asiento]){
                                    listaAsientos[fila][asiento] = true;
                                    System.out.println("Asiento reservado correctamente.\n");
                                } else {
                                    System.out.println("Asiento ocupado.\n");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese fila (1-5)");
                            fila = objScanner.nextInt() - 1;
                            System.out.println("Ingrese el asiento (1-10)");
                            asiento = objScanner.nextInt() - 1;
                            if (fila <0 || fila > 5 || asiento < 0 || asiento > 10){
                                System.out.println("Ingresa valores dentro del rango de opciones.\n");
                            } else {
                                if (listaAsientos[fila][asiento]){
                                    listaAsientos[fila][asiento] = false;
                                    System.out.println("Asiento cancelado correctamente.\n");
                                } else {
                                    System.out.println("Asiento libre.\n");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Asientos disponibles (fila-asiento)");
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 10; j++) {
                                    if (!listaAsientos[i][j]){
                                        System.out.print(" ("+(i+1)+"-"+(j+1)+") ");
                                    } else {
                                        System.out.print("   X   ");
                                    }
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            int ocupados = 0, disponibles = 0;
                            for (boolean[] filaAsiento: listaAsientos){
                                for (boolean asientoOcupado: filaAsiento){
                                    if (asientoOcupado){
                                        ocupados++;
                                    } else  {
                                        disponibles++;
                                    }
                                }
                            }
                            System.out.println("Total de asientos ocupados: "+ ocupados);
                            System.out.println("Total de asientos disponibles: "+ disponibles);
                            break;
                    }
                }
            } catch (Exception e){
                System.out.println("INGRESA LOS VALORES CORRECTAMENTE >:[\n");
            }

            objScanner.nextLine();
        } while (opcion != 5);
    }
}
