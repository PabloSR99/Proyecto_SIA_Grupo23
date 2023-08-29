import java.io.*;
import java.util.*;
public class proyecto {

    public static void main(String arg[])throws IOException {
        
        
        int opcion=-1;
        String ingresado;

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Enfermero> mapaEnfermeros  = new HashMap<>();

        while (opcion != 0){

            System.out.println("Ingrese la opcion del menu: ");
            System.out.println("1 -> Agregar enfermero");
            System.out.println("2 -> Agregar turno");
            System.out.println("3 -> Mostrar turnos de un enfermero");
            System.out.println("4 -> Eliminar turno" );
            System.out.println("5 -> Mostrar turnos");
            System.out.println("0 -> Salir");

            ingresado=lector.readLine();
            opcion=Integer.parseInt( ingresado );

            switch (opcion) {
                case 1:

                    System.out.println("Ingrese el nombre del enfermero: ");
                    String nombre = lector.readLine();

                    System.out.println("Ingrese el rut del enfermero: ");
                    String rut = lector.readLine();

                    Enfermero auxEnfermero = new Enfermero(nombre, rut);
                    mapaEnfermeros.put(rut, auxEnfermero);
                
                    break;
                case 2:

                    System.out.println("Ingrese el rut del enfermero: ");
                    String rutEnfermero = lector.readLine();

                    if(mapaEnfermeros.containsKey(rutEnfermero)){

                        System.out.println("Ingrese el dia del turno: ");
                        String dia = lector.readLine();

                        System.out.println("Ingrese la hora de entrada del turno: ");
                        String entrada = lector.readLine();

                        System.out.println("Ingrese la hora de salida del turno: ");
                        String salida = lector.readLine();

                        Horario auxHorario = new Horario(entrada, salida, dia);
                        mapaEnfermeros.get(rutEnfermero).agregarTurno(auxHorario);
                    }else{
                        System.out.println("El rut ingresado no existe");
                    }
                    
                    break;

                case 3:

                    System.out.println("Ingrese el rut del enfermero: ");
                    String auxRut = lector.readLine();

                    if(mapaEnfermeros.containsKey(auxRut)){
                        mapaEnfermeros.get(auxRut).mostrarTurnos(mapaEnfermeros.get(auxRut));
                        
                       

                    }else{
                        System.out.println("El rut ingresado no existe");
                    }
                
                    break;
                case 4:
                        
                    break;  
                case 5:
                        
                    break; 
                default:
                    break;
            }
        }
    }
}