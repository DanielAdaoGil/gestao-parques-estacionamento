package gestaoparques.service;
import gestaoparques.model.Parque;
import gestaoparques.model.Viatura;
import gestaoparques.util.FicheiroUtil;
public class ViaturaService{
    private static Viatura[] viaturas = new Viatura[150]; 
    private static int totalViaturas = 0;
    
    public static boolean matriculaValida(String matricula) {
        return matricula.matches("[A-Z]{2}-\\d{4}-[A-Z]{2}")          // XX-NNNN-XX
            || matricula.matches("[A-Z]{3}-\\d{2}-\\d{2}")            // XXX-NN-NN
            || matricula.matches("[A-Z]{2}-\\d{2}-\\d{2}-[A-Z]{2}");  // formato do exemplo "LD-28-62-RF"
    }

    public static void registarViatura(String matricula, int horaEntrada, Parque parque) {
        if (!matriculaValida(matricula)) {
            System.out.println("Matrícula inválida!");
            System.out.println("Modelos de Matrícula:\n XX-NN-NN-XX \n XXX-NN-NN");
            return;
        }
    
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

    FicheiroUtil.guardarLinha("dados/viaturas.txt", v.toString());
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
        String[] linhas = FicheiroUtil.lerLinhas("dados/viaturas.txt");
        for(int i = 0; i < linhas.length; i++){
            if(linhas[i] != null && !linhas[i].isEmpty()){
                viaturas[totalViaturas] = Viatura.fromString(linhas[i]);
                totalViaturas++;
        }
        }       
    }
}