package Exer05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th05 extends Thread {
    private String servidor;

    public Th05(String servidor) {
        this.servidor = servidor;
    }

    public void run() {
        System.out.println("Iniciando operação de ping para " + servidor);

        try {
            Process processo = Runtime.getRuntime().exec("ping -4 -c 10 " + getEnderecoServidor());
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));

            String linha;
            int totalPings = 0;
            int totalTempo = 0;

            while ((linha = leitor.readLine()) != null) {
                if (linha.contains("time=")) {
                    int indexInicio = linha.indexOf("time=") + 5;
                    int indexFim = linha.indexOf(" ms", indexInicio);
                    String tempoString = linha.substring(indexInicio, indexFim);
                    int tempo = Integer.parseInt(tempoString);
                    totalTempo += tempo;
                    totalPings++;
                    System.out.println("Servidor: " + servidor + " - Tempo: " + tempo + " ms");
                }
            }

            if (totalPings > 0) {
                double tempoMedio = totalTempo / (double) totalPings;
                System.out.println("Tempo médio para " + servidor + ": " + tempoMedio + " ms");
            } else {
                System.out.println("Não foi possível realizar ping para " + servidor);
            }

            leitor.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private String getEnderecoServidor() {
        switch (servidor) {
            case "UOL":
                return "www.uol.com.br";
            case "Terra":
                return "www.terra.com.br";
            case "Google":
                return "www.google.com.br";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Th05 threadUOL = new Th05("UOL");
        Th05 threadTerra = new Th05("Terra");
        Th05 threadGoogle = new Th05("Google");

        threadUOL.start();
        threadTerra.start();
        threadGoogle.start();
    }
}
