import java.util.ArrayList;

public class Doctor extends Personal{

    private ArrayList<Enfermero> enfermerosAsignados;
    private String especialidad;

    public Doctor(String nombre, String rut,String especialidad){
        super(nombre, rut);
        this.especialidad = especialidad;
        enfermerosAsignados = new ArrayList<>();
    }
    public void setEspecialidad(String nombre) {
        this.especialidad = nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void asignarEnfermero(Enfermero enfermero){
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

    public Enfermero getEnfermero(int i){
        return enfermerosAsignados.get(i);
    }
    public int getSize2(){
        return enfermerosAsignados.size();
    }



}
