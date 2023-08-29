public class Horario{

    private String entrada;
    private String salida;
    private String dia;

    public Horario(String entrada, String salida, String dia) {
        
        this.entrada = entrada;
        this.salida = salida;
        this.dia = dia;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSalida() {
        return salida;
    }

    public String getDia() {
        return dia;
    }    
}