/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.vista;

import Empleado.control.GestionEmpleado;
import java.util.*;
import static producto.control.GestionPedidos.*;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import tienda.vista.VistaTienda;
import util.Colors;

/**
 *
 * @author Marta_08
 */
public class VisualizacionProducto {

    private static List<Producto> factura = new ArrayList<>();

    public static void menuModificarProducto() {

        int opcion;
        int numProducto;
        numProducto = listarProductos();
        System.out.println("*****MENU MODIFICAR PRODUCTO*******\n" + "2.1 Modificar nombre de producto " + "\n" + "2.2 Modificar precio de producto " + "\n"
                + "2.3 Modificar código de producto " + "\n");
        opcion = opcionMenuModificarProducto();
        switch (opcion) {
            case 1:
                modificarNombreProducto(numProducto - 1);
                break;
            case 2:
                modificarPrecioProducto(numProducto - 1);
                break;
            case 3:
                modificarCodigoProducto(numProducto - 1);
                break;

        }

    }

    public static void menuHacerPedido() {
        int opcion;
        int productoDeseado;
        ProductoDAOImp productoDAOImp = new ProductoDAOImp();
        System.out.println("\n\n*****MENU HACER PEDIDO*******\n" + "1.1 Añadir producto a la cecsta " + "\n" + "1.2 Visualizar precio total de la cesta " + "\n"
                + "1.3 Imprimir factura " + "\n" + "1.4 Terminar pedido \n");
        opcion = opcionMenuHacerPedido();

        switch (opcion) {
            case 1:
                productoDeseado = listarProductos();
                ProductoEstaFactura(productoDeseado);
                menuHacerPedido();
                break;
            case 2:
                System.out.println(PrecioTotal(factura));
                menuHacerPedido();
                break;
            case 3:
                mostrarFactura();
                productoDAOImp.escribirFactura(factura);
                break;
            case 4: 
                break;

        }
    }

    public static void mostrarFactura() {
        System.out.println("-----FACTURA----");
        for (Producto producto : factura) {
            System.out.println(producto.toString());
        }
        System.out.println(PrecioTotal(factura));
        System.out.println("Atendido por: " + GestionEmpleado.empleadoActual().getEmpleado_nombre());
    }

    public static void ProductoEstaFactura(int posicion) {
        boolean estaFactura = false;
        for (Producto producto : factura) {
            if (producto.getProducto_codigo() == obtenerProducto(posicion - 1).getProducto_codigo()) {
                estaFactura = true;
            }
        }
        if (estaFactura == true) {
            System.out.println(Colors.RED + "Producto ya anyadido en la factura." + Colors.BLACK);
            menuHacerPedido();
        } else {
            System.out.println(Colors.GREEN + "Producto anyadido a la factura con exito" + Colors.BLACK);
            factura.add(obtenerProducto(posicion - 1));

        }

    }

}
