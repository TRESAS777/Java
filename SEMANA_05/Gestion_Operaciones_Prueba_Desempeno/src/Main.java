import controller.ClienteController;
import controller.CompraController;
import controller.ProductoController;
import entity.Cliente;
import entity.Compra;
import entity.Producto;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        CompraController compraController = new CompraController();
        ProductoController productoController = new ProductoController();

        while (true){
            String[] options = {"Cliente", "Compra", "Producto", "Back"};
            int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (valor){
                case 0:
                    clienteMenu(clienteController);
                    break;
                case 1:
                    compraMenu(compraController);
                    break;
                case 2:
                    productoMenu(productoController);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting program...");
                    return;
            }
        }

    }

    public static void clienteMenu(ClienteController clienteController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                clienteController.insertCliente(new Cliente());
                break;
            case 1:
                clienteController.updateCliente(new Cliente());
                break;
            case 2:
                clienteController.deleteCliente(new Cliente());
                break;
            case 3:
                clienteController.getAll();
                break;
            case 4:
                break;
        }
    }

    public static void compraMenu(CompraController compraController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú compras", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                compraController.insertCompra(new Compra());
                break;
            case 1:
                compraController.updateCompra(new Compra());
                break;
            case 2:
                compraController.deleteCompra(new Compra());
                break;
            case 3:
                compraController.getAll();
                break;
            case 4:
                break;
        }
    }

    public static void productoMenu(ProductoController productoController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú producto", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                productoController.insertProducto(new Producto());
                break;
            case 1:
                productoController.updateProducto(new Producto());
                break;
            case 2:
                productoController.deleteProducto(new Producto());
                break;
            case 3:
                productoController.getAll();
                break;
            case 4:
                break;
        }
    }
}