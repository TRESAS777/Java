package gestionCursos;

import java.util.ArrayList;

public class Curso {

    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante (Estudiante estudiante){
        listaEstudiantes.add(estudiante);
    }

    public boolean eliminarEstudiante (int idEstudiante){
        return listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEstudiante);
    }

    public void listarEstudiantes(){
        System.out.println("Estudiantes en el curso: " + nombre + ":");
        for (Estudiante estudiante : listaEstudiantes){
            System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre());
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

}
