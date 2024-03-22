import java.util.ArrayList;
import java.util.Scanner;

public class Curso {

    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiante;

    private static int idEstudiante = 1;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiante = new ArrayList<>();
    }

    public void guardarEstudiante(Scanner objScanner){

        System.out.println("Agregar nuevo estudiante\n");
        System.out.println("Ingresa el nombre del estudiante: ");
        String nombre = objScanner.next();
        System.out.println("Ingresa el email del estudiante: ");
        String email = objScanner.next();

        Estudiante objEstudiante = new Estudiante(idEstudiante,nombre,email);
        idEstudiante ++ ;

        if (this.listaEstudiante.add(objEstudiante)){
            System.out.println("Estudiante agregado correctamente.");
        } else {
            System.out.println("NO se agrego el estudiante.");
        }
    }

    public void listarEstudiantes(){
        if (this.listaEstudiante.isEmpty()){
            System.out.println("El curso".concat(this.nombre).concat(" No tiene estudiantes"));
        } else {
            System.out.println("\nLista de estudiante en el curso - " + this.nombre);
            for (Estudiante estudiante : this.listaEstudiante) {
                System.out.println(estudiante.toString());
            }
        }
    }

    public void eliminarEstudiante(Scanner objScanner){
        this.listarEstudiantes();
        System.out.println("Indique el Id del estudiante a eliminar: ");
        int idRemover = objScanner.nextInt();
        if (this.listaEstudiante.removeIf(estudiante -> estudiante.getId() == idRemover)){
            System.out.println("Estudiante eliminado");
        }else{
            System.out.println("Estudiante no eliminado");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaEstudiante=" + listaEstudiante +
                '}';
    }
}
