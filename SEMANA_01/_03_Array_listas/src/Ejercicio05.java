import javax.swing.*;
import java.util.ArrayList;

public class Ejercicio05 {
    public static void main(String[] args) {
/*    5. Lista de Reproducción Musical: Imagina que estás creando una aplicación para
    gestionar listas de reproducción musicales. Cada canción es representada
    simplemente por su nombre. El programa debe permitir:
     Añadir y remover canciones de la lista de reproducción.
     Mostrar la canción actual y las siguientes en la lista.
     Saltar a la siguiente canción.*/

        //Creación de la lista de canciones
        ArrayList<String> playList = new ArrayList<>();

        int option = 0;
        int singActual = 0;

        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        PLAYLIST
                        1. Agregar canción
                        2. Remover canción
                        3. Mostrar canción actual y siguientes de la lista
                        4. Saltar a la siguiente canción
                        5. Salir
                        Ingrese una opción:\s"""));

                switch (option){
                    case 1://Añadir una canción
                        // Pedimos la nueva canción a la playlist
                        String nuevaSing = JOptionPane.showInputDialog("Ingrese el nombre de la canción a agregar");
                        //Agregamos la canción a la playlist
                        playList.add(nuevaSing.toLowerCase());
                        JOptionPane.showMessageDialog(null, "Agregada correctamente");
                        break;
                    case 2://Eliminar una canción de la playlist
                        // pedimos al usuario el nombre de la canción a eliminar
                        String singEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la canción a ELIMINAR");
                        //Eliminar la canción con ese nombre
                        if (playList.remove(singEliminar.toLowerCase())){
                            JOptionPane.showMessageDialog(null, "Eliminada correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró en la playList");
                        }
                        break;
                    case 3: // mostrar canción actual y siguiente en la lista
                        if (playList.isEmpty()){
                            JOptionPane.showMessageDialog(null, "La playList está vacía");
                        } else { /*guardar en texto todas las canciones*/
                            String listaTotal = "";
                            //agregamos la canción actual
                            listaTotal += "Canción actual\n"+playList.get(singActual)+"\n"+
                            "\nSiguiente en la lista:\n";
                            for (int i = singActual; i < playList.size() -1; i++) {
                                //por cada iteration agregamos a la variable listaTotal
                                listaTotal += playList.get(i+1)+"\n";
                            }
                            JOptionPane.showMessageDialog(null,listaTotal);
                        }
                        break;
                    case 4://salta la siguiente canción
                        //Validar que si alla una siguiente canción
                        if (singActual + 1 < playList.size()){
                            singActual++;
                            JOptionPane.showMessageDialog(null,playList.get(singActual)+ " Reproducida correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null,"PlayList finalizada");
                            singActual = 0;
                        }
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Caracteres no validos");
            }
        } while (option != 5);

    }
}
