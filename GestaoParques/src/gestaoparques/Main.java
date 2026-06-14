package gestaoparques;
import gestaoparques.service.MultaService;
import gestaoparques.service.ParqueService;
import gestaoparques.service.ViaturaService;
import gestaoparques.ui.Menu;

public class Main {
    public static void main(String[] args) {
    ParqueService.carregarFicheiro();
    ViaturaService.carregarFicheiro();
    MultaService.carregarFicheiro();
    Menu.mostrarMenuPrincipal();

    }
}
