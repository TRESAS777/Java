import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {

    private ArrayList<Curso> listaCursos;

    public GestionCurso(){
        this.listaCursos = new ArrayList<>();
    }

    public void guardaCurso(Scanner objScanner){
        System.out.println("Agregar curso\n");
        System.out.println("Ingresa el nombre del curso: ");
        String nombre  = objScanner.next();
        System.out.println("Ingresa el codigo del curso: ");
        String codigo  = objScanner.next();

        if (this.buscarCodigo(codigo) != null){
            System.out.println("El codigo ya existe");
        } else {
            Curso objCurso = new Curso(codigo, nombre);
            this.listaCursos.add(objCurso);
        }
    }

    public Curso buscarCodigo(String codigoBuscar){
        for (Curso cursoTemp: this.listaCursos){
            if (cursoTemp.getCodigo().equalsIgnoreCase(codigoBuscar)){
                return cursoTemp;
            }
        }
        return null;
    }

    public void listarCursos(){
        if (this.listaCursos.isEmpty()){
            System.out.println("No hay cursos");
        } else {
            System.out.println("Lista de cursos");
            for (Curso temp : this.listaCursos){
                System.out.println(temp.toString());
            }
        }
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
