import java.util.*;
import java.io.*;

public class Enfermero extends Personal {
    private ArrayList<Horario> turnos;

    public Enfermero(String nombre, String rut) {
        super(nombre, rut);
        this.turnos = new ArrayList<>();
    }

    public void setTurno(Horario turno) {
        turnos.add(turno);
    }
    public ArrayList<Horario> getTurnos() {
        return turnos;
    }

    public void removeTurno(Horario turno) {

        for (int i = 0; i < getTurnos().size(); i++) {

            if(getTurnos().get(i).getDia().equals(turno.getDia()) && getTurnos().get(i).getEntrada().equals(turno.getEntrada()) && getTurnos().get(i).getSalida().equals(turno.getSalida())) {
                System.out.println("------------------------------------------------------");
                System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida() + " eliminado");
                System.out.println("------------------------------------------------------");
                getTurnos().remove(i);
                break;
            }
        }
    }

    public void mostrarTurnos(){

        System.out.println("Turnos para " + getNombre());
        System.out.println("Rut " + getRut());
        System.out.println("------------------------------------------------------");
        
        for (int i = 0; i < getTurnos().size(); i++) {

            Horario turno = getTurnos().get(i);
            System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida());
            System.out.println("------------------------------------------------------");
        }
        System.out.println();

    }


    //PRUEBA 2
    
}