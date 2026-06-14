package gestaoparques.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheiroUtil{
    
    public static void guardarLinha(String nomeFicheiro, String linha) {
    try {
        FileWriter fw = new FileWriter(nomeFicheiro, true); // true = acrescenta ao invés de false
        fw.write(linha + "\n");
        fw.close();
    } catch (IOException e) {
        System.out.println("Erro ao guardar: " + e.getMessage());
    }
    }
    public static String[] lerLinhas(String nomeFicheiro) {
        try {
        BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
        String[] linhas = new String[100];
        int i = 0;
        String linha;
        while ((linha = br.readLine()) != null) {
            linhas[i] = linha;
            i++;
        }
        br.close();
        return linhas;
    } catch (IOException e) {
        return new String[0];
    }

    }

}