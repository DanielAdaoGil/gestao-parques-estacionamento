package gestaoparques.model;
public class Multa{
    private String matricula;
    private double valor;
    private String tipo;
    private int hora;
    
    
    public Multa(String matricula, double valor, String tipo, int hora) {
        this.matricula = matricula;
        this.valor = valor;
        this.tipo = tipo;
        this.hora = hora;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    @Override
    public String toString() {
        return getMatricula() + ";" + getValor() + ";" + getTipo()
                + ";" + getHora();
    }
    public static Multa fromMulta(String linha){
        String[] parte = linha.split(";");
        Multa multa = new Multa(parte[0], Double.parseDouble(parte[1]), parte[2], Integer.parseInt(parte[3]));
            return multa;
    }
    public String mostrarMulta(){
        return "\nMultas\n\nMatricula: " +getMatricula() +"\nValor: " + getValor() +"\nTipo: " 
                + getTipo()+"\nHora: " + getHora();
    }
}