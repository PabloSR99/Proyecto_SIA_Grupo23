import java.io.*;
import java.util.*;

public class Control {

    private Map<String, String> mapaEnfermeros;
    private ArrayList <Enfermero> listaEnfermeros;

    public Control() {
        this.mapaEnfermeros = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
    }

    public void datosIni(Control control){
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
    public void agregarEnfermero(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }
    public void agregarEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del enfermero: ");
        String nombre = lector.readLine();

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }


    public void eliminarEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero a eliminar ");
        String rut = lector.readLine();
        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    listaEnfermeros.remove(i);
                    mapaEnfermeros.remove(rut);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
      
    }
    public void mostrarEnfermeros(){
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            listaEnfermeros.get(i).mostrarTurnos();
        }
    }

     public void buscarEnfermero()throws IOException{

         BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

         System.out.println("Ingrese el rut del enfermero a buscar ");
         String auxString = lector.readLine();

        if(mapaEnfermeros.containsKey(auxString)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(auxString)){

                    System.out.println("Enfermero: Nombre: " + listaEnfermeros.get(i).getNombre() + ", Rut: " + listaEnfermeros.get(i).getRut());
                    listaEnfermeros.get(i).mostrarTurnos();
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }

    }
    public void agregarTurno()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    System.out.println("Ingrese el dia del turno: ");
                    String dia = lector.readLine();

                    System.out.println("Ingrese la hora de entrada del turno: ");
                    String entrada = lector.readLine();

                    System.out.println("Ingrese la hora de salida del turno: ");
                    String salida = lector.readLine();

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).setTurno(auxHorario);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }
    public void agregarTurno(String rut, String dia, String entrada, String salida){

        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)) {

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).setTurno(auxHorario);
                }
            }
        }else {
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }

    public void modificarTurno()throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del enfermero para modificar: ");
        String rut = lector.readLine();
        int aux = 0, pos = 0;

        if (mapaEnfermeros.containsKey(rut)) {
            for (int i = 0; i < listaEnfermeros.size(); i++) {
                if (listaEnfermeros.get(i).getRut().equals(rut)) {
                    System.out.println("Ingrese el dia del turno a modificar: ");
                    String dia = lector.readLine();
                    for (int j = 0; j < listaEnfermeros.get(i).getTurnos().size(); j++) {
                        if (listaEnfermeros.get(i).getTurnos().get(j).getDia().equals(dia)) {
                            if (aux >= 1) {
                                System.out.println("Hay mas de un turno con ese dia, ingrese la hora de entrada del turno a modificar: ");
                                String entrada = lector.readLine();
                                if (listaEnfermeros.get(i).getTurnos().get(i).getEntrada().equals(entrada)) {
                                    pos = j;
                                }

                                aux++;

                            } else {
                                pos = j;
                                aux++;
                            }

                        }
                        System.out.println("Ingrese el nuevo dia del turno: ");
                        dia = lector.readLine();
                        listaEnfermeros.get(i).getTurnos().get(pos).setDia(dia);
                        System.out.println("Ingrese la nueva hora de entrada del turno: ");
                        String entradaNueva = lector.readLine();
                        listaEnfermeros.get(i).getTurnos().get(pos).setEntrada(entradaNueva);
                        System.out.println("Ingrese la nueva hora de salida del turno: ");
                        String salidaNueva = lector.readLine();
                        listaEnfermeros.get(i).getTurnos().get(pos).setSalida(salidaNueva);
                        System.out.println("Turno modificado");
                        break;
                    }
                    break;
                }
            }
        }
    }

    public void eliminarTurno()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero para eliminar: ");
        String rut = lector.readLine();

        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    System.out.println("Ingrese el dia del turno: ");
                    String dia = lector.readLine();

                    System.out.println("Ingrese la hora de entrada del turno: ");
                    String entrada = lector.readLine();

                    System.out.println("Ingrese la hora de salida del turno: ");
                    String salida = lector.readLine();

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).removeTurno(auxHorario);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }

    
}
