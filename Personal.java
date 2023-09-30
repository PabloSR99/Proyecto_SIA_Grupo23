import java.util.ArrayList;

public class Personal {
    private String nombre;
    private String rut;

    public Personal(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }
    public String getRut() {
        return rut;
    }

    public String identificarse(){
        return "Nombre: " + this.nombre +
                "Rut: " + this.rut;
    }

}
