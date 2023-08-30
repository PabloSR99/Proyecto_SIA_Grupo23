import java.io.*;
import java.util.*;

public class Control {

    private Map<String, String> mapaEnfermeros;
    private ArrayList <Enfermero> listaEnfermeros;
    private int totalEnfermeros;

    public Control() {
        this.mapaEnfermeros = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
        this.totalEnfermeros = 0;
    }

    public int getTotalEnfermeros() {
        return totalEnfermeros;
    }

    public String buscarEnfermero(String rut){
        return mapaEnfermeros.get(rut);
    }
    
    public void agregarEnfermero(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
        totalEnfermeros++;
    }

    public void eliminarEnfermero(String rut){
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            if(listaEnfermeros.get(i).getRut().equals(rut)){
                listaEnfermeros.remove(i);
                totalEnfermeros--;
                mapaEnfermeros.remove(rut);
                break;
            }
        }
    }

    public void mostrarEnfermeros(){
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            System.out.println("Enfermero " + (i + 1) + ": Nombre: " + listaEnfermeros.get(i).getNombre() + ", Rut: " + listaEnfermeros.get(i).getRut());
            System.out.println("Turnos: ");
        }
    }

    
}
