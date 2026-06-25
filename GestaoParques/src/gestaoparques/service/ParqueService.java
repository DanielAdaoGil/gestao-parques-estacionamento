package gestaoparques.service;
import gestaoparques.util.FicheiroUtil;
import gestaoparques.model.Parque;
public class ParqueService{
    private static Parque[] parques = new Parque[4];
    private static int totalParques = 0;
    
    public static void registarParque(String nomeParque, int capacidade, double valorHora, double valorAdicional){

        Parque p = new Parque(nomeParque, capacidade, valorHora, valorAdicional);
        parques[totalParques] = p;
        totalParques ++; 
        FicheiroUtil.guardarLinha("dados/parques.txt", p.toString());
        System.out.println("Parque " + nomeParque + " registado com sucesso!");
    }
    public static Parque buscarParque(String nomeParque){
        for(int i = 0; i < totalParques; i++){
            if(parques[i].getNome().equalsIgnoreCase(nomeParque)){
                return parques[i];
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
                parques[totalParques] = Parque.fromParque(linhas[i]);
                totalParques++;
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
}