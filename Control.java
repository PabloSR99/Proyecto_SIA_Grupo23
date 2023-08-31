import java.io.*;
import java.util.*;

public class Control {

    private Map<String, String> mapaEnfermeros;
    private ArrayList <Enfermero> listaEnfermeros;
    private int totalEnfermeros;

    public Control() {
        this.mapaEnfermeros = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
        this.totalEnfermeros = 0;
    }

    public int getTotalEnfermeros() {
        return totalEnfermeros;
    }
    
    public void agregarEnfermero(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
        totalEnfermeros++;
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
        totalEnfermeros++;
    }


    public void eliminarEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero a eliminar ");
        String rut = lector.readLine();
        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    listaEnfermeros.remove(i);
                    totalEnfermeros--;
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
