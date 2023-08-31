import java.io.*;
import java.util.*;

public class proyecto {

    public static void datosIni(Control control){
        //1° enfermero
        String nombre = "Juan", rut = "12345678-9", dia = "1/09/2023", entrada = "8:00", salida = "16:00";

        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        dia = "2/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);

        //2° enfermero
        nombre = "Pedro"; rut = "23456789-0"; dia = "3/09/2023"; entrada = "7:45"; salida = "15:45";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "7:30"; salida = "15:30"; dia = "4/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "6:00"; salida = "9:00"; dia = "5/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);

        //3° enfermero
        nombre = "Ana"; rut = "34567890-1"; dia = "4/09/2023";entrada = "8:15";salida = "16:15";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "2:30"; salida = "15:30"; dia = "6/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "7/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);

        //4° enfermero
        nombre = "María";rut = "98765432-1";dia = "1/09/2023";entrada = "9:30";salida = "17:30";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "2:30"; salida = "15:30"; dia = "2/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "3/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "19:00"; salida = "23:30"; dia = "4/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "5/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "1:00"; salida = "20:30"; dia = "6/09/2023";
        control.agregarTurno(rut, dia, entrada, salida);
    }
    public static void main(String arg[])throws IOException {
        
        
        int opcion=-1;
        String ingresado;
        
        Control control = new Control();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        datosIni(control);

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