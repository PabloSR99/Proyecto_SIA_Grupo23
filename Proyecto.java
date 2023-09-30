import java.io.*;

public class Proyecto {

    public static void main(String arg[]){

        Ventanas v;
        Hospital hospital = new Hospital();
        hospital.datosIniEnfermero(hospital);
        hospital.datosIniDoctor(hospital);
        v = new Ventanas(hospital);
        v.setVisible(true);
    }
}