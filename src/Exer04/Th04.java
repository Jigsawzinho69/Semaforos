package Exer04;

import java.util.Random;

public class Th04 extends Thread {
    private static int distanciaMaxima = 1000;
    private static int tamanhoMaximoPulo = 100;
    private String nomeSapo;
    private int distanciaPercorrida;

    public Th04(String nomeSapo) {
        this.nomeSapo = nomeSapo;
        this.distanciaPercorrida = 0;
    }

    public void run() {
        Random rand = new Random();

        while (distanciaPercorrida < distanciaMaxima) {
            int tamanhoPulo = rand.nextInt(tamanhoMaximoPulo + 1);
            distanciaPercorrida += tamanhoPulo;
            if (distanciaPercorrida > distanciaMaxima) {
                distanciaPercorrida = distanciaMaxima;
            }
            System.out.println(nomeSapo + " saltou " + tamanhoPulo + " metros e percorreu " + distanciaPercorrida + " metros.");
        }

        System.out.println(nomeSapo + " chegou e ficou na colocação " + obterColocacao());
    }

    private static int colocacao = 0;
    private static synchronized int obterColocacao() {
        return ++colocacao;
    }

    public static void main(String[] args) {
        Th04[] sapos = new Th04[5];

        for (int i = 0; i < sapos.length; i++) {
            sapos[i] = new Th04("Sapo " + (i + 1));
            sapos[i].start();
        }
    }
}
