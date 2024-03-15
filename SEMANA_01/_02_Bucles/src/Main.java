import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        /* 1. Contador Simple: Escribe un programa que utilice un bucle for para contar del 1 al 10 e
        imprimir cada número en la consola. */
        /*
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("i = " + i);
        }
        */

        /* 2. Suma de Números: Utiliza un bucle while para sumar los números del 1 al 100 e imprimir
        el resultado.*/
        /*
        int contador = 0;
        int sumTotal = 0;
        while (contador <= 100){
            sumTotal += contador;
            contador++;
        }
        System.out.println(sumTotal);
        */

        /* 3. Tabla de Multiplicar: Utiliza un bucle for anidado para imprimir la tabla de multiplicar
        del 1 al 10.*/
        /*
        for ( int i = 1 ; i < 11 ; i++){
            System.out.println("\nTabla del " + i);
            for ( int j = 1 ; j < 10 ; j++){
                System.out.println(i +" * "+j +" = "+ (i*j));
            }
        }
        */

        /* 4. Suma de Números Pares: Escribe un programa que sume solo los números pares del 1 al
        100 usando un bucle for y luego imprime el resultado.*/
        /*
        for ( int i = 1 ; i <= 100 ; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
        */

        /* 5. Validación de Entrada de Usuario: Escribe un programa que solicite al usuario que
        ingrese su edad. Si el usuario ingresa un valor que no es un número válido o está fuera de
        un rango razonable (por ejemplo, 0-120), el programa debe pedirle al usuario que intente de
        nuevo. Utiliza un bucle para seguir solicitando la entrada hasta que sea válida.*/
        /*
        int edad = 0;
        do {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa tu edad: "));
                if (edad <= 0 || edad > 120){
                    JOptionPane.showMessageDialog(null, "Ingresa una edad valida");
                } else if (edad > 0 && edad < 18) {
                    JOptionPane.showMessageDialog(null, "Eres menor de edad");
                } else if (edad >= 18 && edad <= 26) {
                    JOptionPane.showMessageDialog(null, "Eres un adulto joven, sé responsable");
                } else if (edad > 26 && edad <=59) {
                    JOptionPane.showMessageDialog(null, "Eres un adulto, ojalá responsable");
                } else  {
                    JOptionPane.showMessageDialog(null, "Eres un adulto mayor, disfruta de tu vejez");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
            }
        } while (edad != 0);
        */

        /* 6. Verificar un Número Primo: Escribe un programa que utilice un bucle para verificar si un
        número dado es primo o no.*/
        /*
        int numeroPrimo = 0;
        do {
            try {
                numeroPrimo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero"));
                if (numeroPrimo == 2 || numeroPrimo == 3) {
                    JOptionPane.showMessageDialog(null, numeroPrimo + " es un numero primo");
                } else {
                    for (int i = 2; i < numeroPrimo ; i++) {
                        if ( numeroPrimo % 3 == 0 || numeroPrimo % 2 == 0){
                            JOptionPane.showMessageDialog(null, numeroPrimo + " no es un numero primo");
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero "+ numeroPrimo + " es primo");
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
            }
        } while (numeroPrimo != 0);
        */

        /* 7. Juego de Adivinanzas: Crea un pequeño juego de adivinanzas donde el usuario debe
        adivinar un número generado aleatoriamente. Utiliza un bucle do-while para permitir al
        usuario seguir intentando hasta que adivine el número.*/
        /*
        boolean bandera = true;
        int numeroAdivinar = 0;
        do {
            try {
                numeroAdivinar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero"));
                int numeroAleatorio = (int)((Math.random()* numeroAdivinar) +1 );
                JOptionPane.showMessageDialog(null, "El numero aleatorio es: " + numeroAleatorio);
                if (numeroAleatorio == numeroAdivinar){
                    JOptionPane.showMessageDialog(null, "Adivinaste el numero, urra" );
                    bandera = false;
                } else {
                    JOptionPane.showMessageDialog(null, "No acertaste, intenta nuevamente...");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
            }
        } while (bandera);
        */

        /*8. Cálculo de Interés Compuesto: Crea un programa que calcule el crecimiento de una
        inversión bajo un esquema de interés compuesto. El usuario debe poder ingresar el capital
        inicial, la tasa de interés anual y el número de años. Utiliza un bucle para calcular y mostrar
        el saldo de la inversión al final de cada año.*/
        /*
        try {
            double capitalInvertir = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a invertir: "));
            double interesAnual = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el interes anual: "));
            int yearInversion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de años: "));
            for (int i = 0; i < yearInversion; i++) {
                double interesGanado = capitalInvertir * (interesAnual/100);
                double nuevoCapital = capitalInvertir + interesGanado;
                capitalInvertir = nuevoCapital;
                JOptionPane.showMessageDialog(null, "La ganancia de la inversion fue de: " + interesGanado + "\n tu nuevo capital es de " + nuevoCapital);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
        }
         */

        /* 9. Sistema de Menú Interactivo: Desarrolla un sistema de menú interactivo que muestre
        diferentes opciones al usuario (por ejemplo, 1. Ver saldo 2. Depositar dinero 3. Retirar
        dinero 4. Salir). Utiliza un bucle para permitir al usuario interactuar con el menú hasta que
        elija salir.*/
        /*
        String option;
        double saldo = 0;
        do{
            option = JOptionPane.showInputDialog(null, "\n \n Menu de opciones \n" +
                    "1. Ver saldo \n" +
                    "2. Depositar \n" +
                    "3. Retirar \n" +
                    "4. Salir \n\n " +
                    "Escribe la opcion:");

            switch (option){
                case "1":
                    JOptionPane.showMessageDialog(null, "Tu saldo es: $" + saldo);
                    break;
                case "2":
                    try {
                        String precioString = JOptionPane.showInputDialog(null, "Ingresa el valor a depositar: \n"
                                + "$ ");
                        double precio = Double.parseDouble(precioString);
                        if (precio <= 0){
                            JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
                        } else {
                            saldo += precio;
                            JOptionPane.showMessageDialog(null, "Has depositado: $ "+precio);
                        }
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
                    }
                    break;
                case "3":
                    try{
                        double valorRetiroString = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el valor a retirar: " ));
                        if (valorRetiroString <= 0){
                            JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
                        } else {
                            if (valorRetiroString <= saldo){
                                JOptionPane.showMessageDialog(null, "El valor a retirar es: " + valorRetiroString);
                                saldo -= valorRetiroString;
                                JOptionPane.showMessageDialog(null, "El saldo es: " + saldo);
                            } else {
                                JOptionPane.showMessageDialog(null, "Fondos insuficientes ");
                            }
                        }
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Ingresa el valor correctamente");
                    }
                    break;
            }
        } while (!option.equals("4"));
        */

    }
}