import java.util.*;
import java.io.*;

public class Enfermero{
    private String nombre;
    private String rut;
    private ArrayList <Horario> turnos;

    public Enfermero(String nombre, String rut){

        setNombre(nombre);
        setRut(rut);
        this.turnos = new ArrayList<>();
        
    }
    /*public Enfermero(String rut) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del enfermero: ");
        setNombre(lector.readLine());
        setRut(rut);
        this.turnos = new ArrayList<>();
    }*/

    public String getNombre() {
        return nombre;
    }
    
    public String getRut() {
        return rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setTurno(Horario turno) {

        turnos.add(turno);
    }

    public ArrayList<Horario> getTurnos() {
        return turnos;
    }

    public void removeTurno(Horario turno) {

        for (int i = 0; i < turnos.size(); i++) {

            if(turnos.get(i).getDia().equals(turno.getDia()) && turnos.get(i).getEntrada().equals(turno.getEntrada()) && turnos.get(i).getSalida().equals(turno.getSalida())) {

                System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida() + " eliminado");
                turnos.remove(i);
                break;
            }
        }
    }

    public void mostrarTurnos(){

        System.out.println("Turnos para " + nombre);
        System.out.println("Rut " + rut);
        
        for (int i = 0; i < turnos.size(); i++) {

            Horario turno = turnos.get(i);
            System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida());
        }
        System.out.println();
 
    }


    //PRUEBA 2
    
}