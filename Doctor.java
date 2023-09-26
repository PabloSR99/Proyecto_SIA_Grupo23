import java.util.ArrayList;

public class Doctor extends Personal{

    private ArrayList<Enfermero> enfermerosAsignados;
    public Doctor(String nombre, String rut){

        super(nombre, rut);
        enfermerosAsignados = new ArrayList<>();

    }

    public void addEnfermero(Enfermero enfermero){
        enfermerosAsignados.add(enfermero);
    }

    public void removeEnfermero(Enfermero enfermero){
        enfermerosAsignados.remove(enfermero);
    }





}
