import java.io.*;

public class Proyecto {


    public static void main(String arg[])throws IOException {

        
        int opcion=-1;
        String ingresado;

        Ventanas v;
        Hospital hospital = new Hospital();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        hospital.datosIniEnfermero(hospital);
        hospital.datosIniDoctor(hospital);
        v = new Ventanas(hospital);
        v.setVisible(true);

    }
}