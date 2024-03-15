package gestionCursos;

public class Main {

    public static void main(String[] args) {
        
        GestionCurso gestionCurso  = new GestionCurso();
        
        Curso curso1 = new Curso("A001","Introducción a la programación.");
        Curso curso2 = new Curso("A002","Estructura de Datos.");

        Estudiante estudiante1 = new Estudiante(1, "Josefina Antonio","josefina@dominio.com");
        Estudiante estudiante2 = new Estudiante(2, "Carla Castaño","carla@dominio.com");

        curso1.agregarEstudiante(estudiante1);
        curso2.agregarEstudiante(estudiante2);

        gestionCurso.agregarCurso(curso1);
        gestionCurso.agregarCurso(curso2);

        gestionCurso.listarEstudiantesCursos("A001");
        gestionCurso.listarEstudiantesCursos("A002");
    }
}
