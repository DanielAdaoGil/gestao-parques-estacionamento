package gestaoparques.service;
import  gestaoparques.model.Multa;
import gestaoparques.util.FicheiroUtil;
public class MultaService{
    private static Multa[] multas = new Multa[600];
    private static int totalMultas = 0;

    public static void aplicarMulta(String matricula, double valor, String tipo, int hora){
        Multa multa = new Multa(matricula, valor, tipo, hora);
        multas[totalMultas] = multa;
        totalMultas++;
        FicheiroUtil.guardarLinha("dados/multas.txt", multa.toString());
        System.out.println("Multa aplicada à viatura " + matricula + " — Tipo: " + tipo + " Valor: " + valor);
    } 
    public static void listarMultas(){
       if(totalMultas == 0){
        System.out.println("Sem multas registadas!");
       return;
       }else{
        for(int i = 0; i < totalMultas; i++){
            System.out.println(multas[i].mostrarMulta());
        }
       }  
    }
    public static void carregarFicheiro(){
        String[] dados = FicheiroUtil.lerLinhas("dados/multas.txt");
        for(int i = 0; i < dados.length; i++){
            if(dados[i] != null && !dados[i].isEmpty()){
                multas[totalMultas] = Multa.fromMulta(dados[i]);
                totalMultas++;  
            }
        }

    }

    public static int getTotalMultas() {
    return totalMultas;
}

public static double getFaturacaoMultas() {
    double total = 0;
    for (int i = 0; i < totalMultas; i++) {
        total += multas[i].getValor();
    }
    return total;
}
    
}