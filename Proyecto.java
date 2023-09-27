import java.io.*;

public class Proyecto {


    public static void main(String arg[])throws IOException {

        
        int opcion=-1;
        String ingresado;

        Ventanas v;
        Hospital hospital = new Hospital();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        hospital.datosIni(hospital);
        //v = new Ventanas(hospital);
        //v.setVisible(true);

        while (opcion != 0){

            System.out.println("======================================================");
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
            System.out.println("======================================================");
            ingresado=lector.readLine();
            opcion=Integer.parseInt( ingresado );

            switch (opcion) {
                case 1:

                    hospital.agregarEnfermeroAlSistema();
                    break;
                case 2:

                    hospital.eliminarEnfermeroDelSistema();
                    break;
                case 3:

                    hospital.asignarEnfermeroADoctor();
                    break;
                case 4:
                    hospital.mostrarEnfermeros();
                    break;
                case 5:

                    hospital.buscarEnfermero();
                    break;  
                case 6:

                    hospital.agregarTurnoAEnfermero();
                    break;
                case 7:

                    hospital.modificarTurno();
                    break;
                case 8:

                    hospital.eliminarTurno();
                    break;

                case 0:

                    hospital.guardarDatos(hospital);
                    System.out.println("======================================================");
                    System.out.println("Saliendo del programa...");
                    System.out.println("======================================================");

                default:
                    break;
            }

        }
    }
}