import java.io.*;

public class Proyecto {


    public static void main(String arg[])throws IOException {

        
        int opcion=-1;
        String ingresado;

        Ventanas v;
        Hospital hospital = new Hospital();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        hospital.datosIniEnfermero(hospital);
        hospital.datosIniDoctor(hospital);
        v = new Ventanas(hospital);
        v.setVisible(true);

        /*
        while (opcion != 0){

            System.out.println("======================================================");
            System.out.println("""
                    Ingrese la opcion del menu:
                    1 -> Agregar doctor al sistema
                    2 -> Eliminar doctor del sistema
                    3 -> Mostrar doctores y enfermeros
                    4 -> Asignar enfermero a doctor
                    5 -> Desasignar enfermero a doctor
                    6 -> Agregar enfermero al sistema
                    7 -> Eliminar enfermero del sistema
                    8 -> Agregar turno a enfermero
                    9 -> Eliminar turno
                    10 -> Modificar turno
                    11 -> Mostrar enfermeros
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

                    hospital.mostrarDoctoresYEnfermeros();
                    break;
                case 4:
                    hospital.asignarEnfermeroADoctor();
                    break;
                case 5:

                    hospital.desasignarEnfermeroADoctor();
                    break;  
                case 6:

                    hospital.agregarEnfermeroAlSistema();
                    break;
                case 7:

                    hospital.eliminarEnfermeroDelSistema();
                    break;
                case 8:

                    hospital.agregarTurnoAEnfermero();
                    break;
                case 9:

                        hospital.agregarTurnoAEnfermero();
                        break;
                case 10:

                        hospital.modificarTurno();
                        break;
                case 11:

                        hospital.mostrarEnfermeros();
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
    */

    }
}