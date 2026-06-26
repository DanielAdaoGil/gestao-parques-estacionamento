package gestaoparques.ui;

import gestaoparques.service.MultaService;
import gestaoparques.service.ParqueService;
import gestaoparques.service.ViaturaService;

public class Relatorio {

    public static void mostrarRelatorio() {
        System.out.println("\n=============================");
        System.out.println("        RELATÓRIOS");
        System.out.println("=============================");
        System.out.println("1. Listar todas as multas");
        System.out.println("=============================");
        MultaService.listarMultas();
        System.out.println("=============================");
        System.out.println("2. Listar todas as Viaturas");
        System.out.println("=============================");
        ViaturaService.listarViaturas();
        System.out.println("=============================");
        System.out.println("2. Listar todas os Parques");
        System.out.println("=============================");
        ParqueService.listarParques();
    }
}