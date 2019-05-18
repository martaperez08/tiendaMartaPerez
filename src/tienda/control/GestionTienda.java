/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.control;

import Empleado.control.GestionEmpleado;
import Empleado.dominio.Empleado;
import tienda.vista.VistaTienda;
import util.Colors;

/**
 *
 * @author Marta_08
 */
public class GestionTienda {

    private static Empleado empleado;

    public static void start() {
        System.out.println("*******BIENVENIDO AL PROGRAMA TIENDAS BY MARTA*********");
        GestionEmpleado.sistemaGestionEmpleados();
        empleado = GestionEmpleado.empleadoActual();
        System.out.println(Colors.GREEN+"\nDATOS CORRECTOS !"+Colors.BLACK);
        System.out.println("\nHa inidicado sesion " + empleado.getEmpleado_nombre()+"\n");
        VistaTienda.menuPrincipal(empleado);
    }
}
