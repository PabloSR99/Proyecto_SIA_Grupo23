import java.util.*;

public class Enfermero{

    private String nombre;
    private String rut;
    private ArrayList <Horario> turnos;

    public Enfermero(String nombre, String rut){

        this.nombre = nombre;
        this.rut = rut;
        this.turnos = new ArrayList<>();
        
    }

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

    public void agregarTurno(Horario turno) {

        turnos.add(turno);

    }



    public void mostrarTurnos(Enfermero enfermeros){

        System.out.println("Turnos para " + nombre);
        System.out.println("Rut " + rut);
        
        for (int i = 0; i < turnos.size(); i++) {

            Horario turno = turnos.get(i);
            System.out.println("Turno " + (i + 1) + ": Día: " + turno.getDia() + ", Entrada: " + turno.getEntrada() + ", Salida: " + turno.getSalida());
        }
 
    }


    //PRUEBA 2
    
}