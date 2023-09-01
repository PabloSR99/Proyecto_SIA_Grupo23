import java.io.*;
import java.util.*;

public class proyecto {


    public static void main(String arg[])throws IOException {
        
        
        int opcion=-1;
        String ingresado;
        
        Control control = new Control();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        control.datosIni(control);

        while (opcion != 0){

            System.out.println("""
                    Ingrese la opcion del menu:
                    1 -> Agregar enfermero
                    2 -> Eliminar enfermero
                    3 -> Mostrar enfermeros y sus turnos
                    4 -> Buscar enfermero
                    5 -> Agregar turno de enfermero
                    6 -> Modificar turno de enfermero
                    7 -> Eliminar turno de enfermero
                    0 -> Salir""");

            ingresado=lector.readLine();
            opcion=Integer.parseInt( ingresado );

            switch (opcion) {
                case 1:

                    control.agregarEnfermero();
                    break;
                case 2:

                    control.eliminarEnfermero();
                    break;
                case 3:

                    control.mostrarEnfermeros();
                    break;
                case 4:

                    control.buscarEnfermero();
                    break;  
                case 5:

                    control.agregarTurno();
                    break;
                case 6:

                    control.modificarTurno();
                    break;
                case 7:

                    control.eliminarTurno();
                    break;
                default:
                    break;
            }
        }
    }
}