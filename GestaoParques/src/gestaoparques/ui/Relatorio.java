package gestaoparques.ui;

import gestaoparques.service.MultaService;

public class Relatorio {

    public static void mostrarRelatorio() {
        System.out.println("\n=============================");
        System.out.println("        RELATÓRIOS");
        System.out.println("=============================");
        System.out.println("1. Listar todas as multas");
        System.out.println("=============================");
        MultaService.listarMultas();
    }
}