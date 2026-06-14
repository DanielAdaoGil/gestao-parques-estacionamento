package gestaoparques.util;
public class Validador{
    public static boolean validarMatricula(String matricula) {
        // Formato 1: LD-28-62-RF → XX-NN-NN-XX
        // Formato 2: ABC-12-34 → XXX-NN-NN
        return matricula.matches("[A-Z]{2}-\\d{2}-\\d{2}-[A-Z]{2}") ||
               matricula.matches("[A-Z]{3}-\\d{2}-\\d{2}");
    }

    public static boolean validarHoraEntrada(int hora) {
        return hora >= 0 && hora <= 23;
    }
}