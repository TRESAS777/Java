import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
/*
        Libro objLibro = new Libro(
                "La oscuridad de los colores",
                "Martín Blasco",
                false,
                "2015");

        System.out.println(objLibro.getTitulo());

        objLibro.setTitulo("La Oscuridad de los Colores");

        System.out.println(objLibro.getTitulo());

        objLibro.cambiarEstado();

        System.out.println(objLibro);

        //////////------------------------///////////

        Empleado objEmpleado = new Empleado(
                "Fernando",
                "Encargado",
                2000000,
                1);

        objEmpleado.aumentarSalario(10);

        System.out.println(objEmpleado);

        Empleado objEmpleadoNuevo = new Empleado();
        int id = 0;
        Scanner objScanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del empleado:");
        objEmpleadoNuevo.setNombre(objScanner.nextLine());

        System.out.println("Ingresa el salario base del empleado:");
        objEmpleadoNuevo.setSalario(objScanner.nextDouble());

        System.out.println("Ingresa el cargo del empleado:");
        objEmpleadoNuevo.setPosition(objScanner.next());

        System.out.println("Ingresa el porcentaje de aumento del empleado:");
        objEmpleadoNuevo.aumentarSalario(objScanner.nextDouble());
        objEmpleadoNuevo.setId(id);
        id ++;
        System.out.println(objEmpleadoNuevo);

        /////////------------------------///////////

        CuentaBancaria objCuentaBancaria = new CuentaBancaria("Fernando", 2000000);

        objCuentaBancaria.depositarDinero(200000);

        System.out.println(objCuentaBancaria);

        objCuentaBancaria.retirarDinero(800000);

        System.out.println(objCuentaBancaria);

        /////////-----------------------------------////////////////////

        Producto objProducto = new Producto(1,"Computador para programar", 20);

        System.out.println(objProducto);

        objProducto.agregarStock(10);

        objProducto.quitarStock(3);

        System.out.println(objProducto);
*/

        //////////////--------------------------//////////////////

        Estudiante objEstudiante = new Estudiante("Juan");

        objEstudiante.addNota(2.2);
        objEstudiante.addNota(5.0);
        objEstudiante.addNota(4.2);

        System.out.println(objEstudiante + "promedio" + objEstudiante.promedio());

    }
}