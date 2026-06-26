package gestaoparques.model;
public class Parque {
    private String nome;
    private Viatura[] espacos;
    private int capacidade = 150;
    private double valorHora;
    private double valorAdicional;
    private int totalOcupados; //Quantos lugares estão ocupados.
    
    public Parque(String nome, int capacidade,double valorHora, double valorAdicional) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.valorHora = valorHora;
        this.valorAdicional = valorAdicional;
        this.espacos = new Viatura[capacidade];
        this.totalOcupados = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Viatura[] getEspacos() {
        return espacos;
    }

    public void setEspacos(Viatura[] espacos) {
        this.espacos = espacos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public int getTotalOcupados() {
        return totalOcupados;
    }

    public void setTotalOcupados(int totalOcupados) {
        this.totalOcupados = totalOcupados;
    }

    @Override
    public String toString() {
        return getNome() + ";" + getCapacidade() + ";" + getValorHora()
                + ";" + getValorAdicional() + ";" + getTotalOcupados();
    }
    public static Parque fromParque(String linha){
        String[] parte = linha.split(";");
        Parque parque = new Parque(parte[0], Integer.parseInt(parte[1]), Double.parseDouble(parte[2]), Double.parseDouble(parte[3]));
        parque.setTotalOcupados(Integer.parseInt(parte[4]));
        return parque;
    }

  
   public String mostrarParque() {
        return "Nome do Parque: " + getNome() + "\nCapacidade: " + getCapacidade() 
                        + "\nValor por Hora: " + getValorHora() + "\nValor Adicional: " + getValorAdicional() + "\nTotal Ocupados: " + getTotalOcupados() 
                        +"\nTotal de espaços livres: "+ (getCapacidade() - getTotalOcupados());
    } 
    

    
    
    

}
