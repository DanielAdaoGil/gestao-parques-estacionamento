package gestaoparques;

import gestaoparques.model.Parque;
import gestaoparques.model.Viatura;
import gestaoparques.service.ParqueService;
import gestaoparques.service.ViaturaService;

public class Main {
    public static void main(String[] args) {
        
        // Teste 1 — Registar um parque
        ParqueService.registarParque("P001-Campus", 10, 500.0, 250.0);
        
        // Teste 2 — Buscar o parque criado
        Parque p = ParqueService.buscarParque("P001-Campus");
        if (p != null) {
            System.out.println(p.mostrarParque());
        }
        
        // Teste 3 — Registar uma viatura
        ViaturaService.registarViatura("LD-28-62-RF", 8, p);
        
        // Teste 4 — Buscar a viatura
        Viatura v = ViaturaService.buscarViatura("LD-28-62-RF");
        if (v != null) {
            System.out.println(v.mostraViaturas());
        }
    }
}
