/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.control;

import util.Colors;
import java.util.*;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;

/**
 *
 * @author Marta_08
 */
public class GestionPedidos  {

    public static void modificarNombreProducto(int posicionProducto) {
        List<Producto> productosList = ControladorProducto.leerProductos();
        ProductoDAOImp productoDAOImp = new ProductoDAOImp();
        Scanner lector;
        String nuevoNombre;
        boolean existeProducto;
        do {
            existeProducto = false;
            lector = new Scanner(System.in);
            lector.useDelimiter("\n");
            System.out.println("Introduzca en nuevo nombre del producto: ");
            nuevoNombre = lector.next();
            for (Producto producto : productosList) {
                if (producto.getProducto_nombre().toLowerCase().equals(nuevoNombre.toLowerCase())) {
                    existeProducto = true;
                }
            }
            if (existeProducto == true) {
                System.out.println(Colors.RED + "Nombre del  producto ya exite. Intentalo de nuevo" + Colors.BLACK);
            }
        } while (existeProducto == true);

        productosList.get(posicionProducto).setProducto_nombre(nuevoNombre);
        productoDAOImp.actualizarProducto(productosList);
    }

    public static void modificarPrecioProducto(int poscionProducto) {
        List<Producto> productosList = ControladorProducto.leerProductos();
        ProductoDAOImp productoDAOImp = new ProductoDAOImp();
        Scanner lector;
        boolean formatoOK = false;
        double nuevoPrecio = 0.0;
        do {
            lector = new Scanner(System.in);
            System.out.println("Introduzca en nuevo precio del producto: ");
            if (lector.hasNextDouble()) {
                nuevoPrecio = lector.nextDouble();
                formatoOK = true;
            } else {
                System.out.println(Colors.RED + "Formato Erroneo" + Colors.BLACK);
            }
        } while (formatoOK == false);

        productosList.get(poscionProducto).setPrec(nuevoPrecio);
        productoDAOImp.actualizarProducto(productosList);
    }

    public static void modificarCodigoProducto(int posicionProducto) {
        List<Producto> productosList = ControladorProducto.leerProductos();
        ProductoDAOImp productoDAOImp = new ProductoDAOImp();
        Scanner lector;
        int codigoNuevo = 0;
        boolean formatoOK = false;
        boolean existeProducto;
        do {
            existeProducto = false;
            do {
                lector = new Scanner(System.in);
                lector.useDelimiter("\n");
                System.out.println("Introduzca en nuevo codigo del producto: ");
                if (lector.hasNextInt()) {
                    codigoNuevo = lector.nextInt();
                    formatoOK = true;
                } else {
                    System.out.println(Colors.RED + "Entrada invalida." + Colors.BLACK);
                }
            } while (formatoOK == false);
            for (Producto producto : productosList) {
                if (producto.getProducto_codigo() == codigoNuevo) {
                    existeProducto = true;
                }
            }
            if (existeProducto == true) {
                System.out.println(Colors.RED + "Codigo del  producto ya exite. Intentalo de nuevo" + Colors.BLACK);
            }
        } while (existeProducto == true);

        productosList.get(posicionProducto).setProducto_codigo(codigoNuevo);
        productoDAOImp.actualizarProducto(productosList);
    }

    public static int opcionMenuModificarProducto() {
        Scanner lector;
        int opcion = 0;
        Boolean formatoOK = false;
        do {
            lector = new Scanner(System.in);
            System.out.println("Introduzca  una opcion [1-4]: ");
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                if (opcion > 0 && opcion < 4) {
                    formatoOK = true;
                }
            } else {
                System.out.println(Colors.RED + "Entrada invalida." + Colors.BLACK);
            }
        } while (formatoOK == false);
        return opcion;
    }

    public static int listarProductos() {
        int cont = 1;
        System.out.println("\n\n------PRODUCTOS----");
        List<Producto> procutos = ControladorProducto.leerProductos();
        for (Producto procuto : procutos) {

            System.out.println(cont + "#     " + procuto.toString());
            cont++;
        }
        Scanner lector;
        int opcion = 0;
        Boolean formatoOK = false;
        do {
            lector = new Scanner(System.in);
            System.out.println("Introduzca el numero del producto #X: ");
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                if (opcion > 0 && opcion < cont) {
                    formatoOK = true;
                }

            } else {
                System.out.println(Colors.RED + "Entrada invalida." + Colors.BLACK);
            }
        } while (formatoOK == false);
        return opcion;
    }

    public static Producto obtenerProducto(int numProducto) {
        List<Producto> productosList = ControladorProducto.leerProductos();
        return productosList.get(numProducto);
    }

    public static int opcionMenuHacerPedido() {
        Scanner lector;
        int opcion = 0;
        Boolean formatoOK = false;
        do {
            lector = new Scanner(System.in);
            System.out.println("Introduzca  una opcion [1-4]: ");
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                if (opcion > 0 && opcion < 5) {
                    formatoOK = true;
                }
            } else {
                System.out.println(Colors.RED + "Entrada invalida." + Colors.BLACK);
            }
        } while (formatoOK == false);
        return opcion;

    }

    public static String PrecioTotal(List<Producto> productosList) {
        double precioTotal = 0.0;
        for (Producto producto : productosList) {
            precioTotal += producto.getPrec();
        }
        return "\nEl precio total de la factura es de : " + precioTotal;

    }
}
