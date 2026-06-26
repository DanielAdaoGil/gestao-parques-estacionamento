package gestaoparques.ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("\n=============================");
            System.out.println("  GESTÃO DE PARQUES");
            System.out.println("=============================");
            System.out.println("1. Gerir Parques");
            System.out.println("2. Registar Viatura");
            System.out.println("3. Pagamento");
            System.out.println("4. Relatórios");
            System.out.println("5. Sair");
            System.out.println("=============================");
            System.out.print("Escolha uma opção: ");
            
                opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    MenuParque.mostrarMenuParque();
                    break;
                case 2:
                    MenuViatura.mostrarMenuViatura();
                    break;
                case 3:
                    MenuViatura.processarPagamento();
                    break;
                case 4:
                    Relatorio.mostrarRelatorio();
                    break;
                case 5:
                    System.out.println("A sair do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");}
             
            
        } while (opcao != 5);
    }
}