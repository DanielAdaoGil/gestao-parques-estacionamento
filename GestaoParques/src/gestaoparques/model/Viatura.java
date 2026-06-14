package gestaoparques.model;

public class Viatura {
    private String matricula;    
    private int horaEntrada;     
    private int horaSaida;      
    private boolean multada;     
    private String parque;
    private int espaco;
    
    public Viatura(String matricula, int horaEntrada) {
        this.matricula = matricula;
        this.horaEntrada = horaEntrada;
        this.horaSaida = 0;
        this.multada = false;
        this.parque = "";
        this.espaco = -1;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    public boolean isMultada() {
        return multada;
    }

    public void setMultada(boolean multada) {
        this.multada = multada;
    }

    public String getParque() {
        return parque;
    }

    public void setParque(String parque) {
        this.parque = parque;
    }

    public int getEspaco() {
        return espaco;
    }

    public void setEspaco(int espaco) {
        this.espaco = espaco;
    }

    @Override
    public String toString() {
        return getMatricula() + ";" + getHoraEntrada() + ";" + getHoraSaida() + ";" + isMultada() + ";" + getParque() + ";" + getEspaco();
    } 
    public static Viatura fromString(String linha){
        String[] parte = linha.split(";");
        Viatura viatura = new Viatura(parte[0], Integer.parseInt(parte[1]));
        viatura.setHoraSaida(Integer.parseInt(parte[2]));
        viatura.setMultada(Boolean.parseBoolean(parte[3]));
        viatura.setParque(parte[4]);
        viatura.setEspaco(Integer.parseInt(parte[5]));
         return viatura;
    }
    public String mostraViaturas(){
        return "\tDetalhes da Viatura\nMatricula: " + getMatricula() + "\nHora de Entrada: " + getHoraEntrada() + "\nHora de Saida: " + getHoraSaida() + "\nMultada: " + isMultada() + "\nParque: " + getParque() + "\nEspaco: " + getEspaco();
    }
    
    
    

}
