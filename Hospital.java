import java.io.*;
import java.util.*;

public class Hospital {
    private Map<String, String> mapaSistema;
    private ArrayList <Enfermero> listaEnfermeros;
    private ArrayList <Doctor> listaDoctores;
    public Hospital() {
        this.mapaSistema = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
    }
    public void agregarDoctorAlSistma(String nombre, String rut){
        Doctor auxDoctor = new Doctor(nombre, rut);
        mapaSistema.put(rut, rut);
        listaDoctores.add(auxDoctor);
    }
    public void agregarDoctorAlSistma()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del doctor: ");
        String rut = lector.readLine();
        System.out.println("Ingrese el nombre del doctor: ");
        String nombre = lector.readLine();
        Doctor auxDoctor = new Doctor(nombre, rut);
        mapaSistema.put(rut, rut);
        listaDoctores.add(auxDoctor);
    }
    public void mostrarDoctoresYEnfermeros(){
        for (int i = 0; i < listaDoctores.size(); i++) {
            System.out.println("Doctor " + (i + 1) + ": Nombre: " + listaDoctores.get(i).getNombre() + ", Rut: " + listaDoctores.get(i).getRut());
            listaDoctores.get(i).mostrarEnfermerosDeDoctor();
        }
    }
    public void eliminarDoctor()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();
        if(mapaSistema.containsKey(rutDoctor)) {
            for (int i = 0; i < listaDoctores.size(); i++) {
                if (listaDoctores.get(i).getRut().equals(rutDoctor)) {
                    listaDoctores.remove(i);
                    mapaSistema.remove(rutDoctor);
                    break;
                }
            }
        }else{
            System.out.println("El doctor no se encuentra en el sistema");
        }
    }
    public void asignarEnfermeroADoctor(String rutDoctor,String nombre,String rutEnfermero){
        if(mapaSistema.containsKey(rutDoctor)){
            for (int i = 0; i < listaDoctores.size(); i++) {
                if(listaDoctores.get(i).getRut().equals(rutDoctor)){
                    if(mapaSistema.containsKey(rutEnfermero)) {
                        for (int j = 0; j < listaEnfermeros.size(); j++) {
                            if (listaEnfermeros.get(j).getRut().equals(rutEnfermero)) {
                                listaDoctores.get(i).asignarEnfermero(listaEnfermeros.get(j));
                                break;
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("El doctor no se encuentra en el sistema");
        }
    }
    public void asignarEnfermeroADoctor()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();

        if(mapaSistema.containsKey(rutDoctor)){

            for (int i = 0; i < listaDoctores.size(); i++) {

                if(listaDoctores.get(i).getRut().equals(rutDoctor)){

                    System.out.println("Ingrese el rut del enfermero: ");
                    String rutEnfermero = lector.readLine();
                    if(mapaSistema.containsKey(rutEnfermero)){
                        for (int j = 0; j < listaEnfermeros.size(); j++) {
                            if(listaEnfermeros.get(j).getRut().equals(rutEnfermero)){
                                listaDoctores.get(i).asignarEnfermero(listaEnfermeros.get(j));
                                break;
                            }
                        }

                    }else{
                        System.out.println("El enfermero no se encuentra en el sistema");
                    }
                    break;
                }
            }
        }else{
            System.out.println("El doctor no se encuentra en el sistema");
        }
    }
    public void desasignarEnfermeroADoctor()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();

        if(mapaSistema.containsKey(rutDoctor)) {

            for (int i = 0; i < listaDoctores.size(); i++) {

                if (listaDoctores.get(i).getRut().equals(rutDoctor)) {

                    System.out.println("Ingrese el rut del enfermero: ");
                    String rutEnfermero = lector.readLine();
                    if (mapaSistema.containsKey(rutEnfermero)) {
                        for (int j = 0; j < listaEnfermeros.size(); j++) {
                            if (listaEnfermeros.get(j).getRut().equals(rutEnfermero)) {
                                listaDoctores.get(i).QuitarEnfermero(listaEnfermeros.get(j));
                                break;
                            }
                        }

                    } else {
                        System.out.println("El enfermero no se encuentra en el sistema");
                    }
                    break;
                }
            }

        }else{
            System.out.println("El doctor no se encuentra en el sistema");
        }
    }
    public void agregarEnfermeroAlSistema(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaSistema.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }
    public void agregarEnfermeroAlSistema()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del enfermero: ");
        String nombre = lector.readLine();

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaSistema.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }


    public void eliminarEnfermeroDelSistema()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero a eliminar ");
        String rut = lector.readLine();
        if(mapaSistema.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    listaEnfermeros.remove(i);
                    for(int j=0;j<listaDoctores.size();j++){
                        listaDoctores.get(j).QuitarEnfermero(listaEnfermeros.get(i));
                    }
                    mapaSistema.remove(rut);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
      
    }
    public void mostrarEnfermeros(){
        System.out.println("Enfermeros en el sistema");
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            listaEnfermeros.get(i).mostrarTurnos();
        }
    }

     public void buscarEnfermero()throws IOException{

         BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

         System.out.println("Ingrese el rut del enfermero a buscar ");
         String auxString = lector.readLine();

        if(mapaSistema.containsKey(auxString)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(auxString)){

                    System.out.println("Enfermero: " + listaEnfermeros.get(i).getNombre() + ", Rut: " + listaEnfermeros.get(i).getRut());
                    listaEnfermeros.get(i).mostrarTurnos();

                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }

    }
    public void agregarTurnoAEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        if(mapaSistema.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    System.out.println("Ingrese el dia del turno: ");
                    String dia = lector.readLine();

                    System.out.println("Ingrese la hora de entrada del turno: ");
                    String entrada = lector.readLine();

                    System.out.println("Ingrese la hora de salida del turno: ");
                    String salida = lector.readLine();

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).setTurno(auxHorario);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }
    public void agregarTurnoAEnfermero(String rut, String dia, String entrada, String salida){

        if(mapaSistema.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)) {

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).setTurno(auxHorario);
                }
            }
        }else {
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }




    public void modificarTurno()throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del enfermero para modificar: ");
        String rut = lector.readLine();
        int pos = 0;
        boolean aux = false;

        if (mapaSistema.containsKey(rut)) {
            for (int i = 0; i < listaEnfermeros.size(); i++) {
                if (listaEnfermeros.get(i).getRut().equals(rut)) {

                    System.out.println("Ingrese el dia del turno a modificar: ");
                    String dia = lector.readLine();

                    for (int j = 0; j < listaEnfermeros.get(i).getTurnos().size(); j++) {
                        if (listaEnfermeros.get(i).getTurnos().get(j).getDia().equals(dia)) {
                            if (aux == true) {

                                System.out.println("Hay mas de un turno con ese dia, ingrese la hora de entrada del turno a modificar: ");
                                String entrada = lector.readLine();

                                if (listaEnfermeros.get(i).getTurnos().get(i).getEntrada().equals(entrada)) {
                                    pos = j;
                                }
                            } else {
                                pos = j;
                                aux = true;
                            }
                        }
                    }
                    System.out.println("Ingrese el nuevo dia del turno: ");
                    dia = lector.readLine();
                    listaEnfermeros.get(i).getTurnos().get(pos).setDia(dia);
                    System.out.println("Ingrese la nueva hora de entrada del turno: ");
                    String entradaNueva = lector.readLine();
                    listaEnfermeros.get(i).getTurnos().get(pos).setEntrada(entradaNueva);
                    System.out.println("Ingrese la nueva hora de salida del turno: ");
                    String salidaNueva = lector.readLine();
                    listaEnfermeros.get(i).getTurnos().get(pos).setSalida(salidaNueva);
                    System.out.println("Turno modificado");
                    break;
                }
            }
        }
    }

    public void eliminarTurno()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero para eliminar: ");
        String rut = lector.readLine();

        if(mapaSistema.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    System.out.println("Ingrese el dia del turno: ");
                    String dia = lector.readLine();

                    System.out.println("Ingrese la hora de entrada del turno: ");
                    String entrada = lector.readLine();

                    System.out.println("Ingrese la hora de salida del turno: ");
                    String salida = lector.readLine();

                    Horario auxHorario = new Horario(entrada, salida, dia);
                    listaEnfermeros.get(i).removeTurno(auxHorario);

                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
    }

    public void datosIniEnfermero(Hospital hospital){
        String path = "enfermeros.csv"; //
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String nombre = datos[0].trim();
                String rut = datos[1].trim();
                hospital.agregarEnfermeroAlSistema(nombre, rut);

                for (int i = 2; i < datos.length; i += 3) {
                    String dia = datos[i].trim();
                    String entrada = datos[i + 1].trim();
                    String salida = datos[i + 2].trim();
                    hospital.agregarTurnoAEnfermero(rut, dia, entrada, salida);

                }
                System.out.println("-----");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void datosIniDoctor(Hospital hospital){
        String path2 = "doctores.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path2))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");
                String nombreDoctor = datos[0].trim();
                String rutDoctor = datos[1].trim();
                hospital.agregarDoctorAlSistma(nombreDoctor, rutDoctor);

                for (int i = 2; i < datos.length; i += 2) {
                    String nombreEnfermero = datos[i].trim();
                    String rutEnfermero = datos[i + 1].trim();
                    hospital.asignarEnfermeroADoctor(rutDoctor, nombreEnfermero, rutEnfermero);
                }
                System.out.println("-----");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardarDatos(Hospital hospital)throws IOException{

        String path = "enfermeros.csv";
        FileWriter fichero = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fichero);

        for (int i = 0; i < listaEnfermeros.size(); i++) {

            pw.print(listaEnfermeros.get(i).getNombre() + "," + listaEnfermeros.get(i).getRut());

            for (int j = 0; j < listaEnfermeros.get(i).getTurnos().size(); j++) {

                pw.print("," + listaEnfermeros.get(i).getTurnos().get(j).getDia() + "," + listaEnfermeros.get(i).getTurnos().get(j).getEntrada() + "," + listaEnfermeros.get(i).getTurnos().get(j).getSalida());
            }
            pw.println();
        }
        fichero.close();
    }
}

