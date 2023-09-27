import java.util.ArrayList;

public class Doctor extends Personal{

    private ArrayList<Enfermero> enfermerosAsignados;
    public Doctor(String nombre, String rut){

        super(nombre, rut);
        enfermerosAsignados = new ArrayList<>();

    }

    public void asignarEnfermero(Enfermero enfermero){
        enfermerosAsignados.add(enfermero);
    }

    public void QuitarEnfermero(Enfermero enfermero){
        for(int i=0;i<enfermerosAsignados.size();i++){
            if(enfermerosAsignados.get(i).getRut().equals(enfermero.getRut())){
                enfermerosAsignados.remove(i);
                break;
            }
        }
    }
    public void mostrarTurnosDoctor(){

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
    public void mostrarEnfermerosDeDoctor(){
        for (int i = 0; i < enfermerosAsignados.size(); i++) {
            System.out.println("Enfermero " + (i + 1) + ": Nombre: " + enfermerosAsignados.get(i).getNombre() + ", Rut: " + enfermerosAsignados.get(i).getRut());
            System.out.println("------------------------------------------------------");
        }
    }




}
