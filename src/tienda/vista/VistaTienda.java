/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.vista;

import util.Colors;
import Empleado.dominio.Empleado;
import Empleado.control.GestionEmpleado;
import java.util.Scanner;
import producto.vista.VisualizacionProducto;
import tienda.control.GestionTienda;

/**
 *
 * @author Marta_08
 */
public class VistaTienda  {

 
    public static void menuPrincipal(Empleado empleado) {

        int opcion;
        System.out.println("*****MENU PRINCIPAL*******\n" + "1. Hacer pedido " + "\n" + "2. Modificar un producto " + "\n"
                + "3.Cambiar contrasenya empleado " + "\n" + "4. Cerrar sesión " + "\n");
        opcion = opcionMenuPrincipal();
        switch (opcion) {
            case 1:
                VisualizacionProducto.menuHacerPedido();
                VistaTienda.menuPrincipal(empleado);
                break;
            case 2:
                VisualizacionProducto.menuModificarProducto();
                VistaTienda.menuPrincipal(empleado);
                break;
            case 3:
                GestionEmpleado.cambiarPasswordEmpleado(empleado);
                VistaTienda.menuPrincipal(empleado);
                break;
            case 4:
                System.out.println("\n\n\n\n\n");
                GestionTienda.start();
                break;
        }
    }

    public static int opcionMenuPrincipal() {
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

}
