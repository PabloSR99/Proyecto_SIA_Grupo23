public class Horario{

    private String entrada;
    private String salida;
    private String dia;
    private boolean ocupado;
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
    
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }


}