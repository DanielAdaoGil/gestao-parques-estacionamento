package gestaoparques.ui;

import gestaoparques.model.Parque;
import gestaoparques.service.ParqueService;
import java.util.Scanner;

public class MenuParque {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuParque() {
        int opcao = 0;
        do {
            System.out.println("\n=============================");
            System.out.println("  GESTÃO DE PARQUES");
            System.out.println("=============================");
            System.out.println("1. Registar Parque");
            System.out.println("2. Buscar Parque");
            System.out.println("3. Voltar");
            System.out.println("=============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registarParque();
                    break;
                case 2:
                    buscarParque();
                    break;
                case 3:
                    System.out.println("A voltar...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private static void registarParque() {
        scanner.nextLine();
        System.out.print("Nome do parque (ex: P001-Campus): ");
        String nome = scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        System.out.print("Valor por hora (Kz): ");
        double valorHora = scanner.nextDouble();
        System.out.print("Valor hora adicional (Kz): ");
        double valorAdicional = scanner.nextDouble();

        ParqueService.registarParque(nome, capacidade, valorHora, valorAdicional);
    }

    private static void buscarParque() {
        scanner.nextLine();
        System.out.print("Nome do parque: ");
        String nome = scanner.nextLine();
        Parque p = ParqueService.buscarParque(nome);
        if (p != null) {
            System.out.println(p.mostrarParque());
        } else {
            System.out.println("Parque não encontrado!");
        }
    }
}