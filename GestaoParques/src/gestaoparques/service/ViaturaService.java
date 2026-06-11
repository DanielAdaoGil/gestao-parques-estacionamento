package gestaoparques.service;
import gestaoparques.model.Parque;
import gestaoparques.model.Viatura;
import gestaoparques.util.FicheiroUtil;
public class ViaturaService{
    private static Viatura[] viaturas = new Viatura[150]; 
    private static int totalViaturas = 0;
    
    public static void registarViatura(String matricula, int horaEntrada, Parque parque) {
    if (buscarViatura(matricula) != null) {
        System.out.println("Viatura já registada!");
        return;
    }
    // Encontra o próximo espaço livre
    int espaco = ParqueService.proximoEspacoLivre(parque);
    if (espaco == -1) {
        System.out.println("Parque cheio!");
        return;
    }
    // Cria a viatura e atribui o espaço e parque
    Viatura v = new Viatura(matricula, horaEntrada);
    v.setEspaco(espaco);
    v.setParque(parque.getNome());
    viaturas[totalViaturas] = v;
    totalViaturas++;

    // Coloca a viatura no espaço do parque
    parque.getEspacos()[espaco] = v;
    parque.setTotalOcupados(parque.getTotalOcupados() + 1);

    FicheiroUtil.guardarLinha("GestaoParques/dados/viaturas.txt", v.toString());
    System.out.println("Viatura " + matricula + " registada no espaço " + espaco + " do parque " + parque.getNome());
}
    public static Viatura buscarViatura(String matricula){
        for(int i = 0; i < totalViaturas; i++){
            if (viaturas[i].getMatricula().equalsIgnoreCase(matricula)) {
                return viaturas[i];
            }
        }
        return null;
    }
    public static void carregarFicheiro(){
        String[] linhas = FicheiroUtil.lerLinhas("GestaoParques/dados/viaturas.txt");
        for(int i = 0; i < linhas.length; i++){
            if(linhas[i] != null && !linhas[i].isEmpty()){
                viaturas[totalViaturas] = Viatura.fromString(linhas[i]);
                totalViaturas++;
        }
        }       
    }
}