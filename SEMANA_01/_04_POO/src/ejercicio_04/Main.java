package ejercicio_04;

public class Main {

    public static void main(String[] args) {

        Circulo objCirculo = new Circulo(10);
        System.out.println("El área del circulo es: " + objCirculo.calcularArea());

        Rectangulo objRectangulo = new Rectangulo(20,40);
        System.out.println("El área del rectángulo es: " + objRectangulo.calcularArea());

        Cuadrado objCuadrado = new Cuadrado (10.0);
        System.out.println("El cuadrado es: " + objCuadrado.calcularArea());

    }
}
