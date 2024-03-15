package gestionCursos;

import java.util.ArrayList;

public class GestionCurso {

    private ArrayList<Curso> cursos;

    public GestionCurso(){
        cursos = new ArrayList<>();
    }

    public void agregarCurso (Curso curso){
        cursos.add(curso);
    }

    public Curso buscarCursoCodigo(String codigo){
        for (Curso curso : cursos){
            if (curso.getCodigo().equals(codigo)){
                return curso;
            }
        }
        return null;
    }

    public void listarEstudiantesCursos (String codigo){
        Curso curso = buscarCursoCodigo((codigo));
        if (curso != null){
            curso.listarEstudiantes();
        } else {
            System.out.println("Curso no encontrado.");
        }
    }
}
