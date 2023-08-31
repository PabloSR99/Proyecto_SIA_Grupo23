import java.io.*;
import java.util.*;

public class proyecto {

    public static void main(String arg[])throws IOException {
        
        
        int opcion=-1;
        String ingresado;
        
        Control control = new Control();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        while (opcion != 0){

            System.out.println("Ingrese la opcion del menu: ");
            System.out.println("1 -> Agregar enfermero");
            System.out.println("2 -> Eliminar enfermero");
            System.out.println("3 -> Mostrar enfermeros");
            System.out.println("4 -> Buscar enfermero" );
            System.out.println("5 -> Mostrar turno de enfermero");
            System.out.println("6 -> Eliminar turno de enfermero");
            System.out.println("0 -> Salir");

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
                    control.eliminarTurno();

                    break;
                default:
                    break;
            }
        }
    }
}