package ejercicio_04;

import ejercicio_04.FigurasGeometricas;

public class Circulo extends FigurasGeometricas {

    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * (this.radio * this.radio);
    }
}
