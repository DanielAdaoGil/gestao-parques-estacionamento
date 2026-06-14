package gestaoparques.ui;

import gestaoparques.model.Parque;
import gestaoparques.model.Viatura;
import gestaoparques.service.MultaService;
import gestaoparques.service.PagamentoService;
import gestaoparques.service.ParqueService;
import gestaoparques.service.ViaturaService;
import java.util.Scanner;

public class MenuViatura {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuViatura() {
        scanner.nextLine();
        System.out.print("Nome do parque: ");
        String nomeParque = scanner.nextLine();
        Parque p = ParqueService.buscarParque(nomeParque);

        if (p == null) {
            System.out.println("Parque não encontrado!");
            return;
        }

        System.out.print("Matrícula da viatura: ");
        String matricula = scanner.nextLine();
        System.out.print("Hora de entrada: ");
        int hora = scanner.nextInt();

        ViaturaService.registarViatura(matricula, hora, p);
    }

    public static void processarPagamento() {
        scanner.nextLine();
        System.out.print("Matrícula da viatura: ");
        String matricula = scanner.nextLine();

        Viatura v = ViaturaService.buscarViatura(matricula);
        if (v == null) {
            System.out.println("Viatura não registada! A registar e aplicar multa...");
            System.out.print("Nome do parque: ");
            String nomeParque = scanner.nextLine();
            Parque p = ParqueService.buscarParque(nomeParque);
            if (p != null) {
                double multa = PagamentoService.calcularMultaNaoRegistada(p);
                MultaService.aplicarMulta(matricula, multa, "NAO_REGISTADA", 0);
            }
            return;
        }

        System.out.print("Hora de saída: ");
        int horaSaida = scanner.nextInt();
        v.setHoraSaida(horaSaida);

        Parque p = ParqueService.buscarParque(v.getParque());
        double valor = PagamentoService.calcularPagamento(v, p);
        System.out.println("Valor a pagar: " + valor + " Kz");
    }
}