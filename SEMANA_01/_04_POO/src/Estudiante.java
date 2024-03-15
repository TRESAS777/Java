import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private ArrayList<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public void addNota (double nota){
        notas.add(nota);
    }

    public double promedio (){
        if (notas.isEmpty()){
            return 0.0;
        }
        double suma = 0.0;
        for ( double nota : notas){
            suma += nota;
        }
        return suma / notas.size();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", notas=" + notas +
                '}';
    }
}
