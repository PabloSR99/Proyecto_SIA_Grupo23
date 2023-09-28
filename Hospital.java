import java.io.*;
import java.util.*;

public class Hospital {
    private Map<String, String> mapaSistema;
    private Map<String, String> mapaEspecialidades;
    private ArrayList <Enfermero> listaEnfermeros;
    private ArrayList <Doctor> listaDoctores;
    public Hospital() {
        this.mapaSistema = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
    }
    public boolean agregarDoctorAlSistema(String nombre, String rut,String especialidad){
        Doctor auxDoctor = new Doctor(nombre, rut,especialidad);
        try{
            if(mapaSistema.containsKey(rut)){
                throw new PersonalExceptions("El doctor ya se encuentra en el sistema");
            }else{
                mapaSistema.put(rut, rut);
                listaDoctores.add(auxDoctor);

                    if (!mapaEspecialidades.containsKey(especialidad)) {
                        mapaEspecialidades.put(especialidad, especialidad);
                    }

            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void agregarDoctorAlSistema()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del doctor: ");
        String rut = lector.readLine();
        System.out.println("Ingrese el nombre del doctor: ");
        String nombre = lector.readLine();
        System.out.println("Ingrese la espeialidad del doctor: ");
        String especialidad = lector.readLine();
        Doctor auxDoctor = new Doctor(nombre, rut,especialidad);
        try{
            if(mapaSistema.containsKey(rut)){
                throw new PersonalExceptions("El doctor ya se encuentra en el sistema");
            }else{
                mapaSistema.put(rut, rut);
                listaDoctores.add(auxDoctor);
                if(!mapaEspecialidades.containsKey(especialidad)){
                    mapaEspecialidades.put(especialidad,especialidad);
                }
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public String mostrarDoctoresYEnfermeros(){
        for (int i = 0; i < listaDoctores.size(); i++) {

            System.out.println("Doctor " + (i + 1) + ": Nombre: " + listaDoctores.get(i).getNombre());
            System.out.println("Rut: " + listaDoctores.get(i).getRut());
            System.out.println("Especialidad: " + listaDoctores.get(i).getEspecialidad());
            listaDoctores.get(i).mostrarEnfermerosDeDoctor();
        }
        return null;
    }
    public void eliminarDoctor()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();
        try{
            if(mapaSistema.containsKey(rutDoctor)){
                for (int i = 0; i < listaDoctores.size(); i++) {
                    if (listaDoctores.get(i).getRut().equals(rutDoctor)) {
                        listaDoctores.remove(i);
                        mapaSistema.remove(rutDoctor);
                        break;
                    }
                }
            }else{
                throw new PersonalExceptions("El doctor no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void asignarEnfermeroADoctor(String rutDoctor,String nombre,String rutEnfermero){
        try{
            if(mapaSistema.containsKey(rutDoctor)){
                for (int i = 0; i < listaDoctores.size(); i++) {
                    if(listaDoctores.get(i).getRut().equals(rutDoctor)){
                        if(mapaSistema.containsKey(rutEnfermero)){
                            for (int j = 0; j < listaEnfermeros.size(); j++) {
                                if(listaEnfermeros.get(j).getRut().equals(rutEnfermero)){
                                    listaDoctores.get(i).asignarEnfermero(listaEnfermeros.get(j));
                                    break;
                                }
                            }
                        }else{
                            throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
                        }
                    }
                }
            }else{
                throw new PersonalExceptions("El doctor no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void asignarEnfermeroADoctor()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();
        try{
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
                            throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
                        }
                    }
                }
            }else{
                throw new PersonalExceptions("El doctor no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }

    }
    public void desasignarEnfermeroADoctor()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del doctor: ");
        String rutDoctor = lector.readLine();
        try{
            if(mapaSistema.containsKey(rutDoctor)){
                for (int i = 0; i < listaDoctores.size(); i++) {
                    if(listaDoctores.get(i).getRut().equals(rutDoctor)){
                        System.out.println("Ingrese el rut del enfermero: ");
                        String rutEnfermero = lector.readLine();
                        if(mapaSistema.containsKey(rutEnfermero)){
                            for (int j = 0; j < listaEnfermeros.size(); j++) {
                                if(listaEnfermeros.get(j).getRut().equals(rutEnfermero)){
                                    listaDoctores.get(i).QuitarEnfermero(listaEnfermeros.get(j));
                                    break;
                                }
                            }
                        }else{
                            throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
                        }
                    }
                }
            }else{
                throw new PersonalExceptions("El doctor no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarEnfermeroAlSistema(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        try{
            if(mapaSistema.containsKey(rut)){
                throw new PersonalExceptions("El enfermero ya se encuentra en el sistema");
            }else{
                mapaSistema.put(rut, rut);
                listaEnfermeros.add(auxEnfermero);
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarEnfermeroAlSistema()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del enfermero: ");
        String nombre = lector.readLine();

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        try{
            if(mapaSistema.containsKey(rut)){
                throw new PersonalExceptions("El enfermero ya se encuentra en el sistema");
            }else{
                mapaSistema.put(rut, rut);
                listaEnfermeros.add(auxEnfermero);
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarEnfermeroDelSistema()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero a eliminar ");
        String rut = lector.readLine();
        try{
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
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
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
         try{
                 if(mapaSistema.containsKey(auxString)){
                 for (int i = 0; i < listaEnfermeros.size(); i++) {
                     if(listaEnfermeros.get(i).getRut().equals(auxString)){
                         System.out.println("Enfermero: " + listaEnfermeros.get(i).getNombre() + ", Rut: " + listaEnfermeros.get(i).getRut());
                         listaEnfermeros.get(i).mostrarTurnos();
                         break;
                     }
                 }
             }else{
                 throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
             }
         } catch (PersonalExceptions e) {
             System.out.println(e.getMessage());
         }

    }
    public void agregarTurnoAEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        try{
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
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarTurnoAEnfermero(String rut, String dia, String entrada, String salida){
        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        Horario auxHorario = new Horario(entrada, salida, dia);
                        listaEnfermeros.get(i).setTurno(auxHorario);
                        break;
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void modificarTurno()throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del enfermero para modificar: ");
        String rut = lector.readLine();
        int pos = 0;
        boolean aux = false;
        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if (listaEnfermeros.get(i).getRut().equals(rut)) {

                        System.out.println("Ingrese el dia del turno a modificar: ");
                        String dia = lector.readLine();

                        for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {
                            if (listaEnfermeros.get(i).getTurno(j).getDia().equals(dia)) {
                                if (aux == true) {

                                    System.out.println("Hay mas de un turno con ese dia, ingrese la hora de entrada del turno a modificar: ");
                                    String entrada = lector.readLine();

                                    if (listaEnfermeros.get(i).getTurno(i).getEntrada().equals(entrada)) {
                                        pos = j;
                                    }
                                } else {
                                    pos = j;
                                    aux = true;
                                }
                            }
                        }
                        if (aux == false){
                            throw new HorarioExceptions("No hay turnos con ese dia");
                        }else{
                            System.out.println("Ingrese el nuevo dia del turno: ");
                            dia = lector.readLine();
                            listaEnfermeros.get(i).getTurno(pos).setDia(dia);
                            System.out.println("Ingrese la nueva hora de entrada del turno: ");
                            String entradaNueva = lector.readLine();
                            listaEnfermeros.get(i).getTurno(pos).setEntrada(entradaNueva);
                            System.out.println("Ingrese la nueva hora de salida del turno: ");
                            String salidaNueva = lector.readLine();
                            listaEnfermeros.get(i).getTurno(pos).setSalida(salidaNueva);
                            System.out.println("Turno modificado");
                            break;
                        }
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (HorarioExceptions e) {
            System.out.println(e.getMessage());
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarTurno()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero para eliminar: ");
        String rut = lector.readLine();
        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        System.out.println("Ingrese el dia del turno a eliminar: ");
                        String dia = lector.readLine();
                        for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {
                            if(listaEnfermeros.get(i).getTurno(j).getDia().equals(dia)){
                                System.out.println("Turno " + (j + 1) + ": Día: " + listaEnfermeros.get(i).getTurno(j).getDia() + ", Entrada: " + listaEnfermeros.get(i).getTurno(j).getEntrada() + ", Salida: " + listaEnfermeros.get(i).getTurno(j).getSalida() + " eliminado");
                                listaEnfermeros.get(i).removeTurno(listaEnfermeros.get(i).getTurno(j));
                                break;
                            }
                        }
                        break;
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }

    }
    public void mostrarDoctoresPorEspecialidad()throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));



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
                String especialidad = datos[2].trim();
                hospital.agregarDoctorAlSistema(nombreDoctor, rutDoctor,especialidad);

                for (int i = 3; i < datos.length; i += 2) {
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

            for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {

                pw.print("," + listaEnfermeros.get(i).getTurno(j).getDia() + "," + listaEnfermeros.get(i).getTurno(j).getEntrada() + "," + listaEnfermeros.get(i).getTurno(j).getSalida());
            }
            pw.println();
        }
        fichero.close();
    }

}

