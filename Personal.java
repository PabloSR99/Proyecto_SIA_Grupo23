import java.util.ArrayList;

public class Personal {
    private String nombre;
    private ArrayList<Horario> turnos;
    private String rut;

    public Personal(String nombre, String rut, Horario horario) {
        this.nombre = nombre;
        this.turnos = new ArrayList<>();
        this.rut = rut;
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
    public String getNombre() {
        return nombre;
    }
    public String getRut() {
        return rut;
    }
    public ArrayList<Horario> getTurnos() {
        return turnos;
    }
}
