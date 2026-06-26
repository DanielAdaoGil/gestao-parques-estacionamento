package gestaoparques.service;
import gestaoparques.util.FicheiroUtil;
import gestaoparques.model.Parque;
import java.util.ArrayList;

public class ParqueService{
    private static ArrayList<Parque> parques = new ArrayList<>();
    
    public static void registarParque(String nomeParque, int capacidade, double valorHora, double valorAdicional){

        Parque p = new Parque(nomeParque, capacidade, valorHora, valorAdicional);
        parques.add(p);
        FicheiroUtil.guardarLinha("dados/parques.txt", p.toString());
        System.out.println("Parque " + nomeParque + " registado com sucesso!");
    }
    public static Parque buscarParque(String nomeParque){
        for(Parque p : parques){
            if(p.getNome().equalsIgnoreCase(nomeParque)){
                return p;
            }
        }
        return null;
    }
    public static int proximoEspacoLivre(Parque p) {
    for (int i = 0; i < p.getCapacidade(); i++) {
        if (p.getEspacos()[i] == null) {
            return i;
        }
    }
    return -1;
}
    public static void carregarFicheiro(){
        String[] linhas = FicheiroUtil.lerLinhas("dados/parques.txt");
        for(int i = 0; i <linhas.length; i++){
            if (linhas[i] != null && !linhas[i].isEmpty()) {
                parques.add(Parque.fromParque(linhas[i]));
            }
        }
    }

    public static void mostrarEstatisticas(Parque p) {
    int ocupados = p.getTotalOcupados();
    int livres = p.getCapacidade() - ocupados;
    double percentual = (ocupados * 100.0) / p.getCapacidade();
    System.out.println("Lugares ocupados: " + ocupados);
    System.out.println("Lugares livres: " + livres);
    System.out.printf("Lotação: %.1f%%\n", percentual);
}

    public static void listarParques(){
        for (Parque parque : parques) {
            System.out.printf("\n\nNome do Parque: " + parque.getNome() + "\nCapacidade: " + parque.getCapacidade() 
                        + "\nValor por Hora: " + parque.getValorHora() + "\nValor Adicional: " + parque.getValorAdicional() + "\nTotal Ocupados: " + parque.getTotalOcupados() 
                        +"\nTotal de espaços livres: "+ (parque.getCapacidade() - parque.getTotalOcupados()));
        }
    }
}