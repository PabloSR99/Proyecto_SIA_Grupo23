import java.io.*;
import java.util.*;

public class Hospital {
    private Map<String, String> mapaSistema;
    private Map<String, String> mapaEspecialidades;
    private ArrayList <Enfermero> listaEnfermeros;
    private ArrayList <Doctor> listaDoctores;

    // Los comentarios daran detalles de lo que se debe hacer en cada método. El comentario va sobre el método.
    public Hospital() {
        this.mapaSistema = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
        this.mapaEspecialidades = new HashMap<>();
    }

    // Este método debe agregar un doctor al sistema, para esto debe recibir como parámetros el nombre, rut y especialidad del doctor.
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

    // Este método debe agregar un doctor al sistema, los parametros los pide por consola.
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

    // Este método debe mostrar los doctores y enfermeros del sistema.
    public String mostrarDoctoresYEnfermeros(){
        for (int i = 0; i < listaDoctores.size(); i++) {

            System.out.println("Doctor " + (i + 1) + ": Nombre: " + listaDoctores.get(i).getNombre());
            System.out.println("Rut: " + listaDoctores.get(i).getRut());
            System.out.println("Especialidad: " + listaDoctores.get(i).getEspecialidad());
            listaDoctores.get(i).mostrarEnfermerosDeDoctor();
        }
        return null;
    }

    // Este método debe eliminar un doctor del sistema, los parametros los pide por consola.
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

    // Este método debe eliminar un doctor del sistema, para esto debe recibir como parámetro el rut del doctor.
    public boolean eliminarDoctor(String rutDoctor){

        System.out.println("Ingrese el rut del doctor: ");
        try{
            if(mapaSistema.containsKey(rutDoctor)){
                for (int i = 0; i < listaDoctores.size(); i++) {
                    if (listaDoctores.get(i).getRut().equals(rutDoctor)) {
                        listaDoctores.remove(i);
                        mapaSistema.remove(rutDoctor);
                        return true;
                    }
                }
            }else{
                throw new PersonalExceptions("El doctor no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Este método debe asignar un enfermero a un doctor, para esto debe recibir como parámetros el rut del doctor y el rut del enfermero.
    public boolean asignarEnfermeroADoctor(String rutDoctor,String rutEnfermero){
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
        return false;
    }

    // Este método debe asignar un enfermero a un doctor, los parametros los pide por consola.
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

    // Este método debe desasignar un enfermero a un doctor, para esto debe recibir como parámetros el rut del doctor y el rut del enfermero.
    public boolean desasignarEnfermeroADoctor(String rutDoctor,String rutEnfermero){

        try{
            if(mapaSistema.containsKey(rutDoctor)){
                for (int i = 0; i < listaDoctores.size(); i++) {
                    if(listaDoctores.get(i).getRut().equals(rutDoctor)){
                        if(mapaSistema.containsKey(rutEnfermero)){
                            for (int j = 0; j < listaEnfermeros.size(); j++) {
                                if(listaEnfermeros.get(j).getRut().equals(rutEnfermero)){
                                    listaDoctores.get(i).QuitarEnfermero(rutEnfermero);
                                    return true;
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
        return false;
    }

    // Este método debe desasignar un enfermero a un doctor, los parametros los pide por consola.
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
                                    listaDoctores.get(i).QuitarEnfermero(rutEnfermero);
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

    // Este método debe agregar enfermeros al sistema, para esto debe recibir como parámetros el nombre y rut del enfermero.
    public boolean agregarEnfermeroAlSistema(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        try{
            if(mapaSistema.containsKey(rut)){
                throw new PersonalExceptions("El enfermero ya se encuentra en el sistema");

            }else{
                mapaSistema.put(rut, rut);
                listaEnfermeros.add(auxEnfermero);
                return true;
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Este método debe agregar enfermeros al sistema, los parametros los pide por consola.
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

    // Este método debe eliminar un enfermero del sistema, los parametros los pide por consola.
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
                            listaDoctores.get(j).QuitarEnfermero(rut);
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

    // Este método debe eliminar un enfermero del sistema, para esto debe recibir como parámetro el rut del enfermero.
    public boolean eliminarEnfermeroDelSistema(String rut){

        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        listaEnfermeros.remove(i);
                        for(int j=0;j<listaDoctores.size();j++){
                            listaDoctores.get(j).QuitarEnfermero(rut);
                        }
                        mapaSistema.remove(rut);
                        return true;
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Este método debe mostrar los enfermeros del sistema.
    public void mostrarEnfermeros(){
        System.out.println("Enfermeros en el sistema");
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            listaEnfermeros.get(i).mostrarTurnos();
        }
    }



    // Este método debe buscar un enfermero en el sistema, para esto debe recibir como parámetro el rut del enfermero.
    public Enfermero buscarEnfermero(String rut){
        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        return listaEnfermeros.get(i);
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Este método debe agregar un turno a un enfermero, los parametros los pide por consola.
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

    // Este método debe agregar un turno a un enfermero, para esto debe recibir como parámetros el rut del enfermero, el dia, la hora de entrada y la hora de salida.
    public boolean agregarTurnoAEnfermero(String rut, String dia, String entrada, String salida){
        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        Horario auxHorario = new Horario(entrada, salida, dia);
                        listaEnfermeros.get(i).setTurno(auxHorario);
                        return true;
                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Este método debe modificar un turno de un enfermero, para esto debe recibir como parámetros el rut del enfermero, el dia, la hora de entrada y la hora de salida del turno a modificar, el nuevo dia, la nueva hora de entrada y la nueva hora de salida.
    public int modificarTurno(String rut ,String diaOriginal,String entradaOriginal,String salidaOriginal,String nuevoDia,String nuevaEntrada,String nuevaSalida){
        boolean a=false;
        try {
            if (mapaSistema.containsKey(rut)) {
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if (listaEnfermeros.get(i).getRut().equals(rut)) {
                        a=true;
                        for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {
                            if (listaEnfermeros.get(i).getTurno(j).getDia().equals(diaOriginal) && listaEnfermeros.get(i).getTurno(j).getEntrada().equals(entradaOriginal) && listaEnfermeros.get(i).getTurno(j).getSalida().equals(salidaOriginal)) {

                                listaEnfermeros.get(i).getTurno(j).setDia(nuevoDia);
                                listaEnfermeros.get(i).getTurno(j).setEntrada(nuevaEntrada);
                                listaEnfermeros.get(i).getTurno(j).setSalida(nuevaSalida);
                                return 0;

                            }

                        }

                        throw new HorarioExceptions("El turno a modificar no existe.");

                    }
                }
            } else {
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }

        }catch(PersonalExceptions e){
            System.out.println(e.getMessage());
        }
        catch(HorarioExceptions e1){
            System.out.println(e1.getMessage());
        }

        if(a==true)return 2;
        return  1;
    }

    // Este método debe modificar un turno de un enfermero, los parametros los pide por consola.
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
                                if (aux) {

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
                        if (!aux){
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

    // Este método debe eliminar un turno de un enfermero, los parametros los pide por consola.
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

    // Este método debe eliminar un turno de un enfermero, para esto debe recibir como parámetros el rut del enfermero y el dia del turno a eliminar.
    public int eliminarTurno(String rut , String dia ){

        try{
            if(mapaSistema.containsKey(rut)){
                for (int i = 0; i < listaEnfermeros.size(); i++) {
                    if(listaEnfermeros.get(i).getRut().equals(rut)){
                        for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {
                            if(listaEnfermeros.get(i).getTurno(j).getDia().equals(dia)){
                                listaEnfermeros.get(i).removeTurno(listaEnfermeros.get(i).getTurno(j));
                                return 0;
                            }
                        }
                        return 1;

                    }
                }
            }else{
                throw new PersonalExceptions("El enfermero no se encuentra en el sistema");
            }
        } catch (PersonalExceptions e) {
            System.out.println(e.getMessage());
        }
        return 2;
    }

    // Este método debe inicializar los datos de los enfermeros al sistema.
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

    // Este método debe inicializar los datos de los doctores al sistema.
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
                    hospital.asignarEnfermeroADoctor(rutDoctor, rutEnfermero);
                }
                System.out.println("-----");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método debe guardar los datos de los enfermeros en un archivo csv.
    public void guardarDatosEnfermero()throws IOException{

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

    // Este método debe guardar los datos de los doctores en un archivo csv.
    public void guardarDatosDoctor()throws IOException{

        String path = "doctores.csv";
        FileWriter fichero = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fichero);

        for (int i = 0; i < listaDoctores.size(); i++) {

            pw.print(listaDoctores.get(i).getNombre() + "," + listaDoctores.get(i).getRut() + "," + listaDoctores.get(i).getEspecialidad());

            for (int j = 0; j < listaDoctores.get(i).getSize2(); j++) {

                pw.print("," + listaDoctores.get(i).getEnfermero(j).getNombre() + "," + listaDoctores.get(i).getEnfermero(j).getRut());
            }
            pw.println();
        }

        fichero.close();
    }

    // Este método debe generar un reporte de los datos generales del hospital.
    public void generarReporteDeDatos()throws IOException{
        String path = "reporte.csv";
        FileWriter fichero = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fichero);
        String titulo = "Doctor,Rut,Especialidad";
        String titulo2= "Enfermero,Rut,Turno 1,Turno 2,...";
        pw.println(titulo);
        for (int i = 0; i < listaDoctores.size(); i++){
            pw.print(listaDoctores.get(i).getNombre() + "," + listaDoctores.get(i).getRut() + "," + listaDoctores.get(i).getEspecialidad());
            pw.println();
        }
        pw.println(titulo2);
        for (int i = 0; i < listaEnfermeros.size(); i++) {

            pw.print(listaEnfermeros.get(i).getNombre() + "," + listaEnfermeros.get(i).getRut());

            for (int j = 0; j < listaEnfermeros.get(i).getSize(); j++) {

                pw.print("," + listaEnfermeros.get(i).getTurno(j).getDia() + "," + listaEnfermeros.get(i).getTurno(j).getEntrada() + "," + listaEnfermeros.get(i).getTurno(j).getSalida());
            }
            pw.println();
        }
        fichero.close();

    }

    // Este método debe agregar los doctores a un ArrayList.
    public void obtenerDoctores(ArrayList a){
        for(int i=0;i<listaDoctores.size();i++){
            a.add(listaDoctores.get(i));
        }
    }

    // Este método debe agregar los enfermeros a un ArrayList.
    public void obtenerEnfermeros(ArrayList a){
        for(int i=0;i<listaEnfermeros.size();i++){
            a.add(listaEnfermeros.get(i));
        }
    }
}

