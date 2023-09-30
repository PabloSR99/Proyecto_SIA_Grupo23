import java.util.ArrayList;
import java.io.*;
public class Doctor extends Personal{

    private ArrayList<Enfermero> enfermerosAsignados;
    private String especialidad;

    public Doctor(String nombre, String rut,String especialidad){
        super(nombre, rut);
        this.especialidad = especialidad;
        enfermerosAsignados = new ArrayList<>();
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void asignarEnfermero(Enfermero enfermero){
        enfermerosAsignados.add(enfermero);
    }
    public Enfermero getEnfermero(int i){
        return enfermerosAsignados.get(i);
    }
    public void asignarEnfermero()throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre del enfermero");
        String nombre = lector.readLine();
        System.out.println("Ingrese rut del enfermero");
        String rut = lector.readLine();
        Enfermero enfermero = new Enfermero(nombre,rut);
        enfermerosAsignados.add(enfermero);
    }

    public void QuitarEnfermero(String rut){
        for(int i=0;i<enfermerosAsignados.size();i++){
            if(enfermerosAsignados.get(i).getRut().equals(rut)){
                enfermerosAsignados.remove(i);
                break;
            }
        }
    }

    public void mostrarEnfermerosDeDoctor(){
        for (int i = 0; i < enfermerosAsignados.size(); i++) {
            System.out.println("Enfermero " + (i + 1) + ": Nombre: " + enfermerosAsignados.get(i).getNombre() + ", Rut: " + enfermerosAsignados.get(i).getRut());
            System.out.println("------------------------------------------------------");
        }
    }


    public int getSize2(){
        return enfermerosAsignados.size();
    }

    public void obtenerEnfermeros(ArrayList a){
        for(int i=0;i<enfermerosAsignados.size();i++){
            a.add(enfermerosAsignados.get(i));
        }
    }

    @Override
    public String identificarse(){
        return "Nombre: " + getNombre() +
                "Rut: " + getRut() +
                "Especializacion: " + getEspecialidad();
    }

}
