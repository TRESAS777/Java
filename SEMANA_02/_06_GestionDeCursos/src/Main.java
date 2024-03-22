import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Instancias
        Scanner objScanner = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;

        do {
            System.out.println("""
                    MENU DE OPCIONES
                    1. Administrar curso
                    2. Administra estudiantes.
                    3. Salir.
                    """);
            option = objScanner.nextInt();

            switch (option){
                case 1:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                MENU DE CURSOS
                                1. Crear un curso.
                                2. Buscar un curso por código.
                                3. Listar cursos.
                                4.Salir.
                                """);
                        option2 = objScanner.nextInt();
                        switch (option2){
                            case 1:
                                objGestion.guardaCurso(objScanner);
                                break;
                            case 2:
                                System.out.println("Ingresa el código del curso:");
                                String codigo = objScanner.next();
                                System.out.println(objGestion.buscarCodigo(codigo).toString());
                                break;
                            case 3:
                                objGestion.listarCursos();
                                break;
                        }
                    } while (option2 != 4);
                    break;
                case 2:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                MENU DE ESTUDIANTES
                                1. Agregar estudiante.
                                2. Eliminar estudiante.
                                3. Listar Estudiante.
                                4. Salir.
                                """);
                        option3 = objScanner.nextInt();

                        switch (option3){
                            case 1:
                                objGestion.listarCursos();
                                System.out.println("Ingrese el código del curso en el que va a inscribir el estudiante:");
                                String codigo = objScanner.next();
                                Curso curso = objGestion.buscarCodigo(codigo);

                                if (curso == null){
                                    System.out.println("curso no encontrado");
                                } else {
                                    curso.guardarEstudiante(objScanner);
                                }

                                break;
                            case 2://Eliminaar estudiante
                                // 1. Listar todos los cursos
                                objGestion.listarCursos();
                                // 2. Preguntar al usuario el curso del estudiante a eliminar
                                System.out.println("Ingrese el código del curso del estudiante a eliminar");
                                codigo = objScanner.next();
                                // 3. Llamar al método que elimina
                                Curso objCurso = objGestion.buscarCodigo(codigo);
                                if (objCurso == null) {
                                    System.out.println("Código no válido");
                                } else {
                                    //Eliminar
                                    objCurso.eliminarEstudiante(objScanner);
                                }

                                break;
                            case  3:

                                objGestion.listarCursos();
                                System.out.println("Ingrese el código del curso en el que va a inscribir al estudiante:");
                                codigo = objScanner.next();
                                curso = objGestion.buscarCodigo(codigo);

                                if (curso == null){
                                    System.out.println("curso no encontrado");
                                } else {
                                    curso.listarEstudiantes();
                                }

                                break;
                        }

                    } while (option3 != 4);
                    break;
            }

        } while (option != 3);

    }
}