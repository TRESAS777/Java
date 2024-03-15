import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.println nos permite imprimir un mensaje por consola
//        System.out.println("Hello and welcome!");
//        //instanciar la clase Scanner nos permite crear un objeto para leer datos ingresados desde la consola
//        Scanner objScanner = new Scanner(System.in);
//        System.out.println("ingresa tu nombre: ");
//        String nombre = objScanner.nextLine();
//        System.out.println("ingresa tu edad: ");
//        int edad = objScanner.nextInt();
//        System.out.println("Ingresa tu altura: ");
//        double altura = objScanner.nextDouble();
////      shortcut imprimir en consola sout
//        System.out.println("Datos:"+" nombre; "+ nombre + " edad: "+ edad + " altura:"+ altura);
//        objScanner.close();
//        if (edad >= 18){
//            System.out.println(" Eres mayor de edad");
//            if (altura > 1.80 ){
//                System.out.println(" Eres una persona alta");
//            } else if (altura < 1.80 && altura >= 1.70){
//                System.out.println(" Tu estatura es promedio");
//            } else {
//                System.out.println(" Eres bajito de estatura");
//            }
//        } else {
//            System.out.println(" Eres menor de edad");
//        }
//        Ejercicio 1: Calculadora Básica
//        Escribe un programa que pida al usuario dos números y luego muestre el resultado de sumar, restar,
//        multiplicar y dividir esos números. Utiliza tipos de datos primitivos para almacenar los números y
//        los resultados.
        Scanner objScanner1 = new Scanner(System.in);
        while (true){
    String option = JOptionPane.showInputDialog( null,  "MENU DE OPERACIONES \n 1. Suma  \n 2. Resta \n 3. Multiplicacion \n 4. Division");
    // obtener los dos numeros a operar
        String num1 = JOptionPane.showInputDialog(null,"Ingrese el valor del primer numero a operar: ");
        String num2 = JOptionPane.showInputDialog(null,"Ingrese el valor del segundo numero a operar: ");
    // convertir los numeros string a numero double
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
    switch (option) {
        case "1":
            JOptionPane.showMessageDialog(null, a + " + " + b + " = " + (a + b));
            break;
        case "2":
            JOptionPane.showMessageDialog(null, a + " - " + b + " = " + (a - b));
            break;
        case "3":
            JOptionPane.showMessageDialog(null, a + " * " + b + " = " + (a * b));
            break;
        case "4":
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
            } else {
                JOptionPane.showMessageDialog(null, a + " / " + b + " = " + (a / b));
            }
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opcion no valida");
    }
    }
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
         */

         /*
        Ejercicio 1: Calculadora Básica
        Escribe un programa que pida al usuario dos números y luego muestre el resultado de sumar, restar,
        multiplicar y dividir esos números. Utiliza tipos de datos primitivos para almacenar los números y
        los resultados.
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Ingresa el primer numero: ");
        int num1 = objScanner.nextInt();
        System.out.println("Ingresa el segundo numero: ");
        int num2 = objScanner.nextInt();
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        System.out.println("la suma de "+num1+" + "+num2+" = "+suma);
        System.out.println("la resta de "+num1+" - "+num2+" = "+resta);
        System.out.println("la multiplicación de "+num1+" * "+num2+" = "+multiplicacion);

        if (num2 == 0 ){
            System.out.println("no se puede dividir por ese numero");
        } else {
            double division = (double) num1 / num2;
            System.out.println("la división de "+num1+" / "+num2+" = "+division);
        }
         */

         /*
        Ejercicio 2: Verificador de Edad
        Crea un programa que solicite la edad del usuario y determine si es mayor de edad (18 años o más).
        El programa debe imprimir un mensaje indicando si el usuario es mayor de edad o no.
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa tu edad: ");
            int edad = objScanner.nextInt();
            if (edad<1){
                System.out.println("Ingresa una edad válida");
            } else if (edad<18) {
                System.out.println("Eres menor de edad, vive sabiamente para que seas alguien exitoso");
            } else if (edad<26){
                System.out.println("Eres un adulto joven, sé responsable y lucha por tu libertad financiera");
            } else if (edad<60){
                System.out.println("Eres un adulto, ojalá responsable, espero que tengas libertad financiera y puedas crecer mucho mas");
            } else if (edad<121){
                System.out.println("Eres un adulto mayor, disfruta tu vejez");
            } else {
                System.out.println("No eres humano o dinos el secreto ");
            }
        } catch (Exception e){
            System.out.println("Ingresa valores en el rango de 1 a 120.");
        }
          */

         /*
        Ejercicio 3: Conversor de Unidades
        Desarrolla un programa que convierta kilómetros a millas. El programa debe solicitar al usuario que
        introduzca una distancia en kilómetros y luego debe mostrar la distancia equivalente en millas.
        Utiliza el hecho de que una milla es igual a 1.60934 kilómetros.
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Ingresa los kilómetros que quieres convertir a millas:");
        double kiloMetros = objScanner.nextDouble();
        double millas = kiloMetros * 1.60934;
        System.out.println("Las millas son: "+millas);
          */

         /*
        Ejercicio 4: Calculadora de Índice de Masa Corporal (IMC)
        Escribe un programa que calcule el índice de masa corporal (IMC) de una persona. El programa
        debe pedir al usuario su peso en kilogramos y su altura en metros, calcular el IMC y mostrar un
        mensaje con el resultado. La fórmula para calcular el IMC es peso / (altura * altura).
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Ingresa tu peso en Kilógramos:");
        double peso = objScanner.nextDouble();
        System.out.println("Ingresa tu altura en metros:");
        double altura = objScanner.nextDouble();
        double imc = peso / (altura*altura);
        System.out.println("Tu indice de masa corporal es de: "+ imc);
          */

         /*
        Ejercicio 5: Clasificador de Números
        Crea un programa que solicite al usuario un número y muestre un mensaje indicando si el número
        es positivo, negativo o cero. Además, indica si el número es par o impar.
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Ingresa un número:");
        double num = objScanner.nextDouble();
        if (num == 0){
            System.out.println("El número es cero y es NEUTRO");
        } else if (num < 0) {
            if (num % 2 == 0){
                System.out.println("El número es negativo y es PAR");
            } else {
                System.out.println("El número es negativo y es IMPAR");
            }
        } else {
            if ( num % 2 == 0){
                System.out.println("El número es positivo y es PAR");
            } else {
                System.out.println("El número es positivo y es IMPAR");
            }
        }
          */

         /*
        Ejercicio 6: Calculadora de Días del Mes
        Desarrolla un programa que pida al usuario el número de un mes (1-12) y muestre el número de días
        de ese mes. Asume que febrero tiene 28 días. Utiliza una estructura switch para resolverlo.
         */
         /*
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Ingresa el número/mes que desea conocer el numero de días:");
        String mes = objScanner.next();
        switch (mes){
            case "Enero","1","enero":
                System.out.println("Enero tiene 31 días.");
                break;
            case "Febrero","2","febrero":
                System.out.println("Febrero tiene 28 días.");
                break;
            case "Marzo","3","marzo":
                System.out.println("Marzo tiene 31 días.");
                break;
            case "Abril","4","abril":
                System.out.println("Abril tiene 30 días.");
                break;
            case "Mayo","5","mayo":
                System.out.println("Mayo tiene 31 días.");
                break;
            case "Junio","6","junio":
                System.out.println("Junio tiene 30 días.");
                break;
            case "Julio","7","julio":
                System.out.println("Julio tiene 31 días.");
                break;
            case "Agosto","8","agosto":
                System.out.println("Agosto tiene 31 días.");
                break;
            case "Septiembre","9","septiembre":
                System.out.println("Septiembre tiene 30 días.");
                break;
            case "Octubre","10","octubre":
                System.out.println("Octubre tiene 31 días.");
                break;
            case "Noviembre","11","noviembre":
                System.out.println("Noviembre tiene 30 días.");
                break;
            case "Diciembre","12","diciembre":
                System.out.println("Diciembre tiene 31 días.");
                break;
        }
          */

         /*
        Ejercicio 7: Menú Interactivo
        Implementa un programa que muestre un menú con opciones para realizar diferentes operaciones
        matemáticas (por ejemplo, sumar, restar, multiplicar, dividir). El usuario debe poder seleccionar una
        opción ingresando un número, y luego el programa debe pedir los números necesarios para realizar
        la operación elegida y mostrar el resultado. Utiliza una estructura switch para manejar las opciones
        del menú.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        int option = 0;
        double num1 = 0;
        double num2 = 0;
        do {
            objScan = new Scanner(System.in);
            System.out.println("""
                                        
                        MENU DE OPCIONES
                        1. Suma
                        2. Resta
                        3. Multiplicación
                        4. División
                        5. Salir
                        """);
            try {
                option = Integer.parseInt(String.valueOf(objScan.nextInt()));
                if (option != 5){
                    System.out.println("Ingresa el primer número a operar:");
                    num1 = Double.parseDouble(String.valueOf(objScan.nextDouble()));
                    System.out.println("Ingresa el segundo número a operar:");
                    num2 = Double.parseDouble(String.valueOf(objScan.nextDouble()));
                }
            } catch (Exception e) {
                System.out.println("Ingresa valores válidos.");
            }
            switch (option) {
                case 1:
                    double suma = num1 + num2;
                    System.out.println("La suma es: " + suma);
                    break;
                case 2:
                    double resta = num1 - num2;
                    System.out.println("La resta es: " + resta);
                    break;
                case 3:
                    double multiplicacion = num1 * num2;
                    System.out.println("La multiplicación es: " + multiplicacion);
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("No se puede dividir por ese número");
                    } else {
                        double division = num1 / num2;
                        System.out.println("La división es:" + division);
                    }
                    break;
            }
        } while ( option != 5);
          */

         /*
        Ejercicio 8: Cálculo de Promedio
        Escribe un programa que solicite al usuario ingresar tres calificaciones, calcule el promedio y
        muestre un mensaje indicando si el alumno aprueba o no (considera que se aprueba con un
        promedio de 6 o más).
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa la primera calificación");
        double nota1 = objScan.nextDouble();
        System.out.println("Ingresa la segunda calificación");
        double nota2 = objScan.nextDouble();
        System.out.println("Ingresa la tercera calificación");
        double nota3 = objScan.nextDouble();
        double promedio = (nota1+nota2+nota3)/3;
        if (promedio<6.0){
            System.out.println("La nota es: "+promedio+" - REPROBÓ");
        } else {
            System.out.println("La nota es: "+ promedio + " - APROBÓ");
        }
          */

         /*
        Ejercicio 9: Calculadora de Año Bisiesto
        Escribe un programa que le pida al usuario que ingrese un año y determine si es un año bisiesto o
        no. Recuerda que un año es bisiesto si es divisible entre 4, excepto aquellos que son divisibles entre
        100, a menos que también sean divisibles entre 400.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa el año a verificar:");
        int year = objScan.nextInt();
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
            System.out.println("Es año bisiesto");
        } else {
            System.out.println("No es año bisiesto");
        }
          */

         /*
        Ejercicio 10: Calculadora de Propina
        Desarrolla un programa que calcule cuánto dejar de propina en un restaurante. El usuario debe
        ingresar el total de la cuenta y el porcentaje de propina que desea dejar. El programa debe mostrar
        cuánto dinero en propina debe dejar.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingrese el total de la cuenta:");
        double cuenta = objScan.nextDouble();
        System.out.println("Ingresa el porcentaje de propina que deseas dejar:");
        double propina = objScan.nextDouble();
        cuenta += ((cuenta * propina)/100);
        System.out.println("El total a dejar es: " + cuenta);

          */

         /*
        Ejercicio 11: Ordenando Tres Números
        Crea un programa que solicite al usuario ingresar tres números enteros y luego los muestre
        ordenados de menor a mayor. Intenta resolverlo primero con if y else, y luego intenta crear una
        solución usando el operador ternario para práctica adicional.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa el primer número:");
        double num1 = objScan.nextDouble();
        System.out.println("Ingresa el segundo número:");
        double num2 = objScan.nextDouble();
        System.out.println("Ingresa el tercer número:");
        double num3 = objScan.nextDouble();
        if (num1 > num2 && num1 > num3 && num2 > num3){
                System.out.println(num1 + " " + num2 + " " + num3);
        } else if (num1 > num3 && num3 > num2) {
            System.out.println(num1 + " " + num3 + " " + num2);
        } else if (num2 > num1 && num2 > num3 && num1 > num3) {
            System.out.println(num2 + " " + num1 + " " + num3);
        } else if (num2 > num3 && num3 > num1) {
            System.out.println(num2 + " " + num3 + " " + num1);
        } else if (num3 > num2 && num3 > num1 && num2 > num1) {
            System.out.println(num3 + " " + num2 + " " + num1);
        } else {
            System.out.println(num3 + " " + num1 + " " + num2);
        }
          */

         /*
        Ejercicio 12: Generador de Horóscopo
        Implementa un programa que le pida al usuario su mes y día de nacimiento. Luego, basado en esa
        información, muestra su signo del zodíaco. Utiliza una estructura switch para manejar los meses y if
        para los días.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa el dia que cumples años:");
        int day = objScan.nextInt();
        System.out.println("Ingresa el mes que cumples años:");
        String month = objScan.next();
        switch (month){
            case "enero":
                if (day>0 && day < 20){
                    System.out.println("Eres Capricornio");
                } else {
                    System.out.println("Eres Acuario");
                }
                break;
            case "febrero":
                if (day>0 && day < 19){
                    System.out.println("Eres Acuario");
                } else {
                    System.out.println("Eres Piscis");
                }
                break;
            case "marzo":
                if (day>0 && day < 22){
                    System.out.println("Eres Piscis");
                } else {
                    System.out.println("Eres Aries");
                }
                break;
            case "abril":
                if (day>0 && day < 20){
                    System.out.println("Eres Aries");
                } else {
                    System.out.println("Eres Tauro");
                }
                break;
            case "mayo":
                if (day>0 && day < 21){
                    System.out.println("Eres Tauro");
                } else {
                    System.out.println("Eres Géminis");
                }
                break;
            case "junio":
                if (day>0 && day < 21){
                    System.out.println("Eres Géminis");
                } else {
                    System.out.println("Eres Cáncer");
                }
                break;
            case "julio":
                if (day>0 && day < 23){
                    System.out.println("Eres Cáncer");
                } else {
                    System.out.println("Eres Leo");
                }
                break;
            case "Agosto":
                if (day>0 && day < 23){
                    System.out.println("Eres Leo");
                } else {
                    System.out.println("Eres Virgo");
                }
                break;
            case "Septiembre":
                if (day>0 && day < 23){
                    System.out.println("Eres Virgo");
                } else {
                    System.out.println("Eres Libra");
                }
                break;
            case "Octubre":
                if (day>0 && day < 23){
                    System.out.println("Eres Libra");
                } else {
                    System.out.println("Eres Escorpio");
                }
                break;
            case "Noviembre":
                if (day>0 && day < 22){
                    System.out.println("Eres Escorpio");
                } else {
                    System.out.println("Eres Sagitario");
                }
                break;
            case "Diciembre":
                if (day>0 && day < 22){
                    System.out.println("Eres Sagitario");
                } else {
                    System.out.println("Eres Capricornio");
                }
                break;
        }
        */

         /*
        Ejercicio 13: Calculadora de Tarifa de Taxi
        Desarrolla un programa que calcule el costo de un viaje en taxi basándose en la distancia del viaje
        (en kilómetros) y la tarifa base. Puedes añadir una tarifa adicional por kilómetro recorrido. El
        usuario debe ingresar la distancia del viaje.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa el precio base:");
        double base = objScan.nextDouble();
        System.out.println("Ingresa el precio adicional:");
        double adicional = objScan.nextDouble();
        System.out.println("Ingresa los kilómetros:");
        double kilometros = objScan.nextDouble();
        base += (kilometros * adicional);
        System.out.println("El precio  total es: $" + base);
          */

         /*
        Ejercicio 14: Convertidor de Temperatura
        Crea un programa que convierta temperaturas entre grados Celsius y Fahrenheit. El usuario debe
        poder elegir si quiere convertir de Celsius a Fahrenheit o viceversa, y luego ingresar la temperatura.
        Utiliza la fórmula C = (F - 32) * 5/9 para Fahrenheit a Celsius y F = C * 9/5 + 32 para Celsius a
        Fahrenheit.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("""
                Ingresa el número de la opción
                1. Celsius a Fahrenheit
                2. Fahrenheit a Celsius
                """);
        int option = objScan.nextInt();
        System.out.println("Ingresa la temperatura:");
        double temp = objScan.nextDouble();
        switch (option){
            case 1:
                double fahrenheit = ((temp * 9 / 5) + 32);
                System.out.println("La temperatura es: °" + fahrenheit);
                break;
            case 2:
                double celsius = ((temp-32) * 5 / 9);
                System.out.println("La temperatura es: °" + celsius);
                break;
        }
          */

         /*
        Ejercicio 15: Sistema de Calificaciones
        Implementa un programa que le pida al usuario la calificación de un examen (0-100). Basado en la
        calificación, el programa debe mostrar una letra (A, B, C, D, F), donde A es 90-100, B es 80-89,
        etc. Considera utilizar if o switch.
         */
         /*
        Scanner objScan = new Scanner(System.in);
        System.out.println("Ingresa la calificación:");
        int nota = objScan.nextInt();
        if (nota > 89){
            System.out.println("Su calificación es: A");
        } else if (nota > 79) {
            System.out.println("Su calificación es: B");
        } else if (nota > 69) {
            System.out.println("Su calificación es: C");
        } else if (nota > 59) {
            System.out.println("Su calificación es: D");
        } else {
            System.out.println("Su calificación es: F");
        }
          */

    }
}