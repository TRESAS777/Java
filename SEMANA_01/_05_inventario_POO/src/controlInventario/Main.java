package controlInventario;

public class Main {
    public static void main(String[] args) {

        Inventario objInventario = new Inventario();

        Producto producto1 = new Producto(1,"Lápiz",0.50);
        ProductoEspecifico producto2 = new ProductoEspecifico(2,"Cuaderno",1.50,"Papelería","Ecológico");

        objInventario.agregarProducto(producto1);
        objInventario.agregarProducto(producto2);

        objInventario.listarProductos();
        objInventario.eliminarProducto(1);
        System.out.println("Lista de productos en stock");
        objInventario.listarProductos();

//        int option = 0;
//        do {
//            try {
//                option = Integer.parseInt(JOptionPane.showInputDialog("------MENU DE OPCIONES------\n" +
//                        "1. Agregar producto al inventario.\n" +
//                        "2. Eliminar producto del inventario\n" +
//                        "3. Listar productos\n" +
//                        "4. Salir\n" +
//                        "Ingresa una opción:"));
//                switch (option) {
//                    case 1:
//                        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
//                        double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
//                        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
//
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null, "Ingresa una opción");
//                }
//            } catch (Exception e){
//                JOptionPane.showMessageDialog(null, "Ingresa valores válidos");
//            }
//        } while (option != 4);

    }
}