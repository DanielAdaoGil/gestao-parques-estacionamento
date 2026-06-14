package gestaoparques.model;

import gestaoparques.service.ParqueService;
import gestaoparques.service.ViaturaService;

public class texte {
    public static void main(String[] args) {
        //ÁREA DA VIATURA
        /*Viatura v = new Viatura(null, 0);
        v.setMatricula("AMJ-17-05");
        v.setParque("P001-Unitel");
        v.setEspaco(1);
        v.setHoraEntrada(10);
        v.setMultada(false);
        System.out.println(v.toString());*/
        //ÁREA DA MULTA
        /*Multa m = new Multa("AJ-17-05-LD", 2, "NAO", 12);
        m.setMatricula("MLA-23-45");
        m.setValor(17);
        m.setTipo("MultaInv");
        m.setHora(2);
        System.out.println(m.toString());*/
        /*String str = "Esta string contém cinco palavras";
        String[] arrayOfWords = str.split(" ");
        System.out.println(arrayOfWords.length);*/
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
