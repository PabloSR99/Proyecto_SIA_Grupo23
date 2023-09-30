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
    public void setTurno( ) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese día del turno");
        String dia = lector.readLine();
        System.out.println("Ingrese hora de entrada del turno");
        String entrada = lector.readLine();
        System.out.println("Ingrese hora de salida del turno");
        String salida = lector.readLine();
        Horario turno = new Horario(dia, entrada, salida);

        turnos.add(turno);
    }


    public Horario getTurno(int i) {
        return turnos.get(i);
    }
    public int getSize(){
        return turnos.size();
    }
    public void removeTurno(Horario turno) {

        for (int i = 0; i < turnos.size(); i++) {

            if(turnos.get(i).getDia().equals(turno.getDia()) && turnos.get(i).getEntrada().equals(turno.getEntrada()) && turnos.get(i).getSalida().equals(turno.getSalida())) {
                System.out.println("------------------------------------------------------");
                System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida() + " eliminado");
                System.out.println("------------------------------------------------------");
                turnos.remove(i);
                break;
            }
        }
    }

    public void mostrarTurnos(){

        System.out.println("Turnos para " + getNombre());
        System.out.println("Rut " + getRut());
        System.out.println("------------------------------------------------------");
        
        for (int i = 0; i < turnos.size(); i++) {

            Horario turno = turnos.get(i);
            System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida());
            System.out.println("------------------------------------------------------");
        }
        System.out.println();

    }

    public String identificarse() {
        StringBuilder info = new StringBuilder();

        info.append("Nombre: ").append(getNombre()).append("\n");
        info.append("Rut: ").append(getRut()).append("\n");

        for (int i = 0; i < turnos.size(); i++) {
            Horario turno = turnos.get(i);
            info.append("Turno ").append(i + 1).append(": Día: ").append(turno.getDia()).append(", Entrada: ").append(turno.getEntrada()).append(", Salida: ").append(turno.getSalida()).append("\n");
        }

        return info.toString();
    }

    public void obtenerTurnos(ArrayList a){
        for(int i=0;i<turnos.size();i++){
            a.add(turnos.get(i));
        }
    }

}