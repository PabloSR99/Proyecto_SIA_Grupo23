import java.io.*;
import java.util.*;

public class Control {

    private Map<String, String> mapaEnfermeros;
    private ArrayList <Enfermero> listaEnfermeros;

    public Control() {
        this.mapaEnfermeros = new HashMap<>();
        this.listaEnfermeros = new ArrayList<>();
    }

    public void datosIni(Control control){
        String path = "enfermeros.csv"; //
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String nombre = datos[0].trim();
                String rut = datos[1].trim();
                control.agregarEnfermero(nombre, rut);



                for (int i = 2; i < datos.length; i += 3) {
                    String dia = datos[i].trim();
                    String entrada = datos[i + 1].trim();
                    String salida = datos[i + 2].trim();
                    control.agregarTurno(rut, dia, entrada, salida);

                }



                System.out.println("-----");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        //1° enfermero
        String nombre = "Juan", rut = "12345678-9", dia = "Lunes", entrada = "8:00", salida = "16:00";

        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        dia = "Martes";
        control.agregarTurno(rut, dia, entrada, salida);

        //2° enfermero
        nombre = "Pedro"; rut = "23456789-0"; dia = "Miercoles"; entrada = "7:45"; salida = "15:45";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "7:30"; salida = "15:30"; dia = "Jueves";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "6:00"; salida = "9:00"; dia = "Viernes";
        control.agregarTurno(rut, dia, entrada, salida);

        //3° enfermero
        nombre = "Ana"; rut = "34567890-1"; dia = "Jueves";entrada = "8:15";salida = "16:15";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "2:30"; salida = "15:30"; dia = "Sabado";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "Domingo";
        control.agregarTurno(rut, dia, entrada, salida);

        //4° enfermero
        nombre = "María";rut = "98765432-1";dia = "Lunes";entrada = "9:30";salida = "17:30";
        control.agregarEnfermero(nombre, rut);
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "2:30"; salida = "15:30"; dia = "Martes";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "Miercoles";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "19:00"; salida = "23:30"; dia = "Jueves";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "9:00"; salida = "9:30"; dia = "Viernes";
        control.agregarTurno(rut, dia, entrada, salida);
        entrada = "1:00"; salida = "20:30"; dia = "Sabado";
        control.agregarTurno(rut, dia, entrada, salida);

         */
    }
    public void guardarDatos(Control control)throws IOException{

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
    public void agregarEnfermero(String nombre, String rut){
        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }
    public void agregarEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del enfermero: ");
        String nombre = lector.readLine();

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        Enfermero auxEnfermero = new Enfermero(nombre, rut);
        mapaEnfermeros.put(rut, rut);
        listaEnfermeros.add(auxEnfermero);
    }


    public void eliminarEnfermero()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero a eliminar ");
        String rut = lector.readLine();
        if(mapaEnfermeros.containsKey(rut)){

            for (int i = 0; i < listaEnfermeros.size(); i++) {

                if(listaEnfermeros.get(i).getRut().equals(rut)){

                    listaEnfermeros.remove(i);
                    mapaEnfermeros.remove(rut);
                    break;
                }
            }
        }else{
            System.out.println("El enfermero no se encuentra en el sistema");
        }
      
    }
    public void mostrarEnfermeros(){
        for (int i = 0; i < listaEnfermeros.size(); i++) {
            listaEnfermeros.get(i).mostrarTurnos();
        }
    }

     public void buscarEnfermero()throws IOException{

         BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

         System.out.println("Ingrese el rut del enfermero a buscar ");
         String auxString = lector.readLine();

        if(mapaEnfermeros.containsKey(auxString)){

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
    public void agregarTurno()throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el rut del enfermero: ");
        String rut = lector.readLine();

        if(mapaEnfermeros.containsKey(rut)){

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
    public void agregarTurno(String rut, String dia, String entrada, String salida){

        if(mapaEnfermeros.containsKey(rut)){

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

        if (mapaEnfermeros.containsKey(rut)) {
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

        if(mapaEnfermeros.containsKey(rut)){

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

    
}
