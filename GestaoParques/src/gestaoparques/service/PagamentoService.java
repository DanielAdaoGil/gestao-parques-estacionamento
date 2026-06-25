package gestaoparques.service;

import gestaoparques.model.Viatura;
import gestaoparques.model.Parque;

public class PagamentoService {

    private static double faturacaoTotal = 0;

    public static double calcularPagamento(Viatura v, Parque p) {
    int horas = v.getHoraSaida() - v.getHoraEntrada();
    
    if (horas <= 0) {
        System.out.println("Hora de saída inválida!");
        return 0;
    }

    double valor = horas * p.getValorHora();
    faturacaoTotal += valor;
    return valor;
}

    public static double calcularMultaNaoRegistada(Parque parque) {
        return parque.getValorHora() * 10;
    }

}